class Solution {
    public int countVowelPermutation(int n) {
        long a =1,e=1,i=1,o=1,u=1;
        long mod = (long)1e9 + 7;
        
        for(int j=2;j<=n;j++){
            long a1 = (e)%mod;
            long e1 = (a + i)%mod;
            long i1 = (a + e + o + u)%mod;
            long o1 = (i + u)%mod;
            long u1 = (a)%mod;
            a = a1; e = e1; i = i1; o = o1; u = u1;
        }
        return (int)((a+e+i+o+u)%mod);
    }
}