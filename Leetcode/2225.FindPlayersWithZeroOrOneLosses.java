class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] match : matches) {
            if(!map.containsKey(match[0])) map.put(match[0], 0);
            map.put(match[1], map.getOrDefault(match[1], 0) + 1);
        }

        List<Integer> playersNeverLost = new ArrayList<>();
        List<Integer> playersLostOneMatch = new ArrayList<>();
        for(int key : map.keySet()) {
            if(map.get(key) == 0)
                playersNeverLost.add(key);
            if(map.get(key) == 1)
                playersLostOneMatch.add(key);
        }
        Collections.sort(playersNeverLost);
        Collections.sort(playersLostOneMatch);
        return List.of(playersNeverLost, playersLostOneMatch);

    }
}