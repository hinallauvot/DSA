class Solution {
    private int solve(int n, Integer[] dp){
        if(n < 0) return Integer.MAX_VALUE;
        if(n == 0) return 0;
        if(dp[n] !=  null) return dp[n];
        int res = Integer.MAX_VALUE;
        for(int i=1; i*i <= n; i++){
            res = Math.min(res, solve(n - i*i, dp) + 1);
        }
        return dp[n] = res;
    }
    public int numSquares(int n) {
        Integer[] dp = new Integer[n+1];
        return solve(n, dp);
    }
}