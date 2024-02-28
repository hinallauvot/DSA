class Solution {
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        for(String word : words) {
            if(isPalindrome(word)) return word;
        }
        return "";
    }
}