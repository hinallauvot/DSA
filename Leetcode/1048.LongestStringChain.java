class Solution {
    private boolean isPredecessor(String prev, String curr) {
        int prevSize = prev.length();
        int currSize = curr.length();
        if(prevSize != currSize - 1) return false;
        int i = 0, j = 0;
        while(i < prevSize && j < currSize) {
            if(prev.charAt(i) == curr.charAt(j))
                i++;
            j++;
        }
        return i == prevSize;
    }

    private int solve(String[] words, int index, int prevIndex, Integer[][] dp) {
        if(index >= words.length) return 0;
        if(prevIndex != -1 && dp[index][prevIndex] != null) return dp[index][prevIndex];
        int take = 0;
        if(prevIndex == -1 || isPredecessor(words[prevIndex], words[index]))
            take = 1 + solve(words, index+1, index, dp);
        int notTake = solve(words, index+1, prevIndex, dp);
        if(prevIndex != -1)
            dp[index][prevIndex] = Math.max(take, notTake);
        return Math.max(take, notTake);
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (word1, word2) -> word1.length() - word2.length());
        Integer[][] dp = new Integer[words.length][words.length];
        return solve(words, 0, -1, dp);
    }
}