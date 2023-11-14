class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] freq = new int[26];
        int i=0, j=0, count=0;
        while(i<s.length()-2){
            char ch1 = s.charAt(i);
            freq[ch1-'a']++;
            if(freq[ch1-'a'] > 1) {
                i++;
                continue;
            }
            j = s.length()-1;
            while(j > i+1){
                if(s.charAt(j)==ch1) break;
                j--;
            }
            char ch2 = s.charAt(j);
            int[] map = new int[26];
            for(int k=i+1; k<j; k++){
                char ch = s.charAt(k);
                map[ch-'a']++;
                if(map[ch-'a'] > 1) continue;
                else count++;
            }
            i++;
        }
        return count;

    }
}