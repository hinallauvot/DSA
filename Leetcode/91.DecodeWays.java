class Solution {
    private int solve(String s, int index, int N, Integer[] dp) {
        if(index == N) return 1;
        if(s.charAt(index) == '0') return 0;
        int take1 = 0, take2 = 0;
        if(dp[index] != null) return dp[index];
        take1 += solve(s, index + 1, N, dp);
        if(index < N - 1 && (s.charAt(index) == '1'|| s.charAt(index) == '2' && s.charAt(index + 1) < '7')) 
            take2 += solve(s, index + 2, N, dp);
        return dp[index] = take1 + take2; 
    }
    public int numDecodings(String s) {
        Integer[] dp = new Integer[s.length()];
        return solve(s, 0, s.length(), dp);
    }
}
