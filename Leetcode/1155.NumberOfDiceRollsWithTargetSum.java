class Solution {
    int MOD=1000000007;
    public int helper(int n, int k, int target, int sum, Integer[][] dp){
        if(sum == target && n == 0) return 1;
        if(sum > target || n < 0) return 0;
        if(dp[n][sum] != null) return dp[n][sum];
        long ans = 0;
        for(int i=1; i <= k; i++){
            if(i + sum > target )
                break;
            ans = (ans%MOD + helper(n-1, k, target, sum + i, dp)%MOD)%MOD;
        }
        return dp[n][sum] = (int)ans%MOD;
    }
    public int numRollsToTarget(int n, int k, int target) {
        Integer [][] dp = new Integer[n+1][target+1];
        return helper(n, k, target, 0, dp);
    }
}