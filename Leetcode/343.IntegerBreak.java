//Approach - 1 (DP)
class Solution {
    private int solve(int n, Integer[] dp) {
        if(n <= 1) return 1;
        int res = n;
        if(dp[n] != null) return dp[n];
        for(int i = 1; i <= n/2; i++) {
            int product = i*solve(n-i, dp);
            res = Math.max(res, product);
        }
        return dp[n] = res;
    }
    public int integerBreak(int n) {
        if(n <= 3) return n-1;
        Integer[] dp = new Integer[n+1];
        return solve(n, dp);
    }
}

//Approach - 2 (Math)
class Solution {
    public int integerBreak(int n) {
        if(n <= 3) return n-1;
        //3 is the biggest number which cannot be split into two num >= 2, That's why we will pick no's in multiple of 3
        int countNoOfThrees = n/3, rem = n%3;
        if(rem == 0) return (int)Math.pow(3, countNoOfThrees);
        else if(rem == 1) return (int)Math.pow(3, countNoOfThrees-1)*4;
        else return (int)Math.pow(3, countNoOfThrees)*2;
    }
}