class Solution {
    public boolean uniqueOccurrences(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for(int key : map.keySet()) {
            if(!set.contains(map.get(key)))
                set.add(map.get(key));
            else return false;
        }
        return true;
    }
}