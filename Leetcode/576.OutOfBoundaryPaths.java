class Solution {
    int MOD = 1000000007;
    private long solve(int m, int n, int maxMove, int startRow, int startColumn, Long[][][] dp) {
        if(startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n) return 1;
        if(maxMove <= 0) return 0;
        if(dp[startRow][startColumn][maxMove] != null) return dp[startRow][startColumn][maxMove];
        long left = solve(m, n, maxMove - 1, startRow-1, startColumn, dp);
        long right = solve(m, n, maxMove - 1, startRow+1, startColumn, dp);
        long up = solve(m, n, maxMove - 1, startRow, startColumn+1, dp);
        long down = solve(m, n, maxMove - 1, startRow, startColumn-1, dp);
        dp[startRow][startColumn][maxMove] = (left%MOD + right%MOD + up%MOD + down%MOD)%MOD;
        return dp[startRow][startColumn][maxMove];
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Long[][][] dp = new Long[m][n][maxMove+1];
        return (int)solve(m, n, maxMove, startRow, startColumn, dp)%MOD;
    }
}