// There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
// The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
// The robot can only move either down or right at any point in time.
// Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
// The test cases are generated so that the answer will be less than or equal to 2 * 109.
// Companies - Google | Amazon | Apple |Adobe | Bloomberg | Yahoo | Facebook | TikTok | ByteDance | Goldman Sachs | Microsoft | Intuit

class Solution {
    private int solve(int m, int n, int i, int j, Integer[][] dp) {
        if(i < 0 || i >= m || j < 0 || j >= n)
            return 0;
        if(i == m-1 && j == n-1)
            return 1;
        if(dp[i][j] != null) return dp[i][j];
        return dp[i][j] = solve(m, n, i+1, j, dp) + solve(m, n, i, j+1, dp);
    }
    public int uniquePaths(int m, int n) {
        Integer[][] dp = new Integer[m][n];
        return solve(m, n, 0, 0, dp);
    }
}