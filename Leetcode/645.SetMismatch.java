class Solution {
    public int[] findErrorNums(int[] nums) {
        int N = nums.length;
        int dup = 0, miss = 0;
        int[] ans = new int[2];
        int[] freq = new int[N+1];
        for(int i = 0; i < N; i++) {
            freq[nums[i]]++;
        }
        int index = 0;
        for(int i = 1; i <= N; i++) {
            if(freq[i] == 2) dup = i;
            if(freq[i] == 0) miss = i;
        }
        return new int[]{dup, miss};
    }
}