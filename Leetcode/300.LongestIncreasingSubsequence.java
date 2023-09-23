class Solution {
    private int solve(int[] nums, int index, int prevIndex, Integer[][] dp) {
        if(index >= nums.length) return 0;
        if(prevIndex != -1 && dp[index][prevIndex] != null) return dp[index][prevIndex];
        int take = 0;
        if(prevIndex == -1 || nums[index] > nums[prevIndex])
            take = 1 + solve(nums, index+1, index, dp);
        int notTake = solve(nums, index+1, prevIndex, dp);
        if(prevIndex != -1)
            dp[index][prevIndex] = Math.max(take, notTake);
        return Math.max(take, notTake);
    }
    public int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length];
        return solve(nums, 0, -1, dp);
    }
}