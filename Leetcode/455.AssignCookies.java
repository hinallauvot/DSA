class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int res = 0;
        int N = s.length, M = g.length;
        int i = 0, j = 0;
        while(i < M && j < N) {
            if(g[i] <= s[j]) {
                i++;
                res++;
            } 
            j++;
        }
        return res;
    }
}