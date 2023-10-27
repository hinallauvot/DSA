class Solution {
    
    int maxLen = 0;
    int lowIndex = 0;
    
    public String longestPalindrome(String s) {
        int len = s.length();
        
        //if length of string is 0 or 1, then the same string will be palindrome
        if(len < 2) return s;
        
        for(int i=0; i < len; i++){
            findMaxPalindrome(s, i, i);
            findMaxPalindrome(s, i, i+1);
        }
        
        return s.substring(lowIndex, lowIndex + maxLen);
    }
    
    private void findMaxPalindrome(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            if(maxLen < right-left-1){
                maxLen = right-left-1;
                lowIndex = left+1;
            }         
        }
    }
}