class Solution {
    private boolean isValid(String word, int[] count) {
        int[] wordCount = new int[26];
        for(char ch : word.toCharArray()) {
            if(wordCount[ch - 'a'] >= count[ch - 'a'])
                return false;
            wordCount[ch - 'a']++;
        }   
        return true;
    }

    public int countCharacters(String[] words, String chars) {
        int res = 0;
        int[] count = new int[26];
        for(char ch : chars.toCharArray())
            count[ch - 'a']++;

        for(String word : words)
            if(isValid(word, count)) 
                res += word.length();
            
        return res;        
    }
}