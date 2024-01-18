class Solution {
    private int solve(int step, Integer[] dp) {
        if(step == 0) return 1;
        if(step < 0) return 0;
        if(dp[step] != null) return dp[step];
        return dp[step] = solve(step-1, dp) + solve(step-2, dp);
    }
    public int climbStairs(int n) {
        Integer[] dp = new Integer[n+1];
        return solve(n, dp);
    }
}