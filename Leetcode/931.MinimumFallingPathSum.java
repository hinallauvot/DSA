class Solution {
    private int solve(int[][] matrix, int row, int col, Integer[][] dp) {
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix.length) return Integer.MAX_VALUE;
        if(row == matrix.length - 1) return matrix[row][col];
        if(dp[row][col] != null) return dp[row][col];
        return dp[row][col] = matrix[row][col] + Math.min(solve(matrix, row+1, col-1, dp), Math.min(solve(matrix, row+1, col, dp), solve(matrix, row+1, col+1, dp)));
    }
    public int minFallingPathSum(int[][] matrix) {
        int N = matrix.length;
        int minSum = Integer.MAX_VALUE;
        Integer[][] dp = new Integer[N][N];
        for(int i = 0; i < N; i++) {
            minSum = Math.min(minSum, solve(matrix, 0, i, dp));
        }
        return minSum;
    }
}