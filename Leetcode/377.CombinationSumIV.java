class Solution {
    private int solve(int[] nums, int target, int index, Integer[][] dp) {
        if(index > nums.length-1)
            return 0;
        if(target < 0)
            return 0;
        if(target == 0)
            return 1;
        if(dp[index][target] != null) return dp[index][target];
        int pick = 0;
        int notPick = 0;
        pick += solve(nums, target - nums[index], 0, dp); //if take, then start from 0
        notPick += solve(nums, target, index+1, dp);
        return dp[index][target] = pick + notPick;
    }
    public int combinationSum4(int[] nums, int target) {
        Integer[][] dp = new Integer[nums.length+1][target+1];
        return solve(nums, target, 0, dp);
    }
}