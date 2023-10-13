class Solution {
    private int solve(int[] cost, int index, Integer[] dp) {
        if(index >= cost.length) return 0;
        if(dp[index] != null) return dp[index];
        int oneStep = cost[index] + solve(cost, index+1, dp); //take one step
        int twoStep = cost[index] + solve(cost, index+2, dp); //take two steps
        return dp[index] = Math.min(oneStep, twoStep);
    }
    public int minCostClimbingStairs(int[] cost) {
        Integer[] dp = new Integer[cost.length+1];
        return Math.min(solve(cost, 0, dp), solve(cost, 1, dp)); //start from 0 or 1
    }
}