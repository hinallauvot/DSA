class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] freq = new int[nums.length + 1];
        for(int num : nums) {
            if(freq[num] > res.size() - 1)
                res.add(new ArrayList<>());
            res.get(freq[num]).add(num);
            freq[num]++;
        }  
        return res;
    }
}