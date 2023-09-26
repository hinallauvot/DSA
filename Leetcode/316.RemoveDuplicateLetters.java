class Solution {
    public String removeDuplicateLetters(String s) {
        char[] count = new char[26];
        boolean[] taken = new boolean[26];
        //count array
        for(char ch : s.toCharArray())
            count[ch - 'a']++;
        
        StringBuilder sb = new StringBuilder(); //always take stringbuilder as it is faster and mutable
        for(int i = 0; i < s.length(); i++) {
            int n = sb.length();
            char si = s.charAt(i);
            if(count[si - 'a'] == 0) continue; //already taken
            //compare the current char with the last char taken in result
            while(n > 0 && sb.charAt(n - 1) > si && !taken[si- 'a'] && count[sb.charAt(n - 1) - 'a'] > 0) {
                    taken[sb.charAt(n - 1) - 'a'] = false;
                    sb.deleteCharAt(n - 1);
                    n = sb.length();
            }    
            count[si - 'a']--;
            if(!taken[si - 'a']) {
                sb.append(si);
                taken[si - 'a'] = true;
            }
                
        }
        return sb.toString();
    }
}