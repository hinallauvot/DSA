class Solution {
    private int solve(int[] nums, int prevIndex, Integer[] dp) {
        if(prevIndex >= nums.length) return 0;
        if(prevIndex != -1 && dp[prevIndex] != null) return dp[prevIndex];
        int take = 0, notTake = 0;
        if(prevIndex != -1)
            take = nums[prevIndex] + solve(nums, prevIndex + 2, dp);
        notTake = solve(nums, prevIndex + 1, dp);
        if(prevIndex != -1) dp[prevIndex] = Math.max(take, notTake);
        return Math.max(take, notTake);
    }
    public int rob(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        return solve(nums, -1, dp);
    }
}