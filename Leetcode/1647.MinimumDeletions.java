class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int deletions = 0;
        char[] chArray = s.toCharArray();
        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        
        for(int freq : map.values()) {
            while(freq > 0 && set.contains(freq)) {
                freq--;
                deletions++;
            }
            set.add(freq);
        }

        return deletions;
    }   
}