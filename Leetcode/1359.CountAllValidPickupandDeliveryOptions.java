class Solution {
    public int countOrders(int n) {
        int MOD = 1000000007;
        if(n == 1) return 1;
        long res = 1;
        for(int i = 2; i <= n; i++) {
            int spaces = (i-1)*2 + 1;
            int curr = (spaces*(spaces+1)/2);
            res *= curr;
            res %= MOD;
        }
        return (int)res;
    }
}
