// You are given a 0-indexed string s and a dictionary of words dictionary.
// You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary. 
// There may be some extra characters in s which are not present in any of the substrings.
// Return the minimum number of extra characters left over if you break up s optimally.

//Approach 1 - Using Trie + DP
class TrieNode {
    TrieNode[] links;
    boolean flag;

    public TrieNode() {
        links = new TrieNode[26];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public boolean isEnd(){
        return flag;
    }

    public void setEnd() {
        flag = true;
    }
}

class Solution {
    TrieNode root;

    private void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            if(!node.containsKey(ch)) {
                TrieNode newNode = new TrieNode();
                node.put(ch, newNode);
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    private int solve(int index, String s, Integer[] dp) {
        if(index == s.length())
            return 0;
        
        if(dp[index] != null) return dp[index];

        int minAns = solve(index+1, s, dp) + 1;

        TrieNode temp = root;
        int j = index;

        while(j < s.length()) {
            temp = temp.get(s.charAt(j));

            if(temp == null)
                break;
            if(temp.isEnd()) {
                minAns = Math.min(minAns, solve(j+1, s, dp));
            }
            j++;
        }

        return dp[index] = minAns;
    }

    public int minExtraChar(String s, String[] dictionary) {
        root = new TrieNode();
        for(String str : dictionary) 
            insert(str);
        return solve(0, s, new Integer[s.length()+1]);
    }
}

// Approach 2 - Recursion + Memoization
class Solution {
    private int solve(int index, String s, Set<String> set, Integer[] dp) {
        if(index >= s.length()) return 0;

        int min = Integer.MAX_VALUE;
        StringBuffer curr = new StringBuffer();
        if(dp[index] != null) return dp[index];
        for(int i = index; i < s.length(); i++) {
            curr.append(s.charAt(i));
            int currExtra = set.contains(curr.toString()) ? 0 : curr.length();
            min = Math.min(min, currExtra + solve(i+1, s, set, dp));
        }
        return dp[index] = min;
    }
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        Integer[] dp = new Integer[s.length()+1];
        return solve(0, s, set, dp);
    }
}