class Solution {
    public boolean makeEqual(String[] words) {
        int[] count = new int[26];
        int N = words.length;
        for(String word : words)
            for(char ch : word.toCharArray())
                count[ch - 'a']++;

        for(int i = 0; i < 26; i++)
            if(count[i]%N != 0) return false;
            
        return true;
    }
}