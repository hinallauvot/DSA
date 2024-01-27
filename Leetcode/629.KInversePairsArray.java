class Solution {
    int MOD = (int) (1e9 + 7);
    private int getInversions(int n, int k, Integer[][] dp) {
        if (n == 0) return 0;
        if (k == 0) return 1;
        if (dp[n][k] != null) return dp[n][k];
        int result = 0;
        for (int inversion = 0; inversion <= Math.min(k, n - 1); inversion++) {
            result += getInversions(n - 1, k - inversion, dp);
            result %= MOD;
        }
        return dp[n][k] = result;
    }

    public int kInversePairs(int n, int k) {
        Integer[][] dp = new Integer[n + 1][k + 1];
        return getInversions(n, k, dp);
    }
}