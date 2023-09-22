class Solution {
    private boolean solve(String s, String t, int i, int j, Boolean[][] dp) {
        if(i == s.length()) return true;
        if(j == t.length()) return false;
        boolean isValid = false;
        if(dp[i][j] != null) return dp[i][j];
        if(s.charAt(i) == t.charAt(j))
            isValid |= solve(s, t, i+1, j+1, dp);
        else
            isValid |= solve(s, t, i, j+1, dp);
        return dp[i][j] = isValid;
    }
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        if(t.length() == 0 && s.length() != 0) return false;
        Boolean[][] dp = new Boolean[s.length()][t.length()];
        return solve(s, t, 0, 0, dp);
    }
}