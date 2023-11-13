class Solution {
    public boolean isVowel(char c)
    {
        if(c=='a' || c=='A' || c=='e' || c=='E' || c=='i' || c=='I' || c=='o' || c=='O' || c=='u' || c=='U')   
            return true;   
        return false;    
    }
      
    public String sortVowels(String s) {
        int[] counts = new int[53];
        StringBuffer res = new StringBuffer();
        int j = 0;
        for(char ch : s.toCharArray())
            if(isVowel(ch)) 
                counts[ch - 'A']++;

        for(int i = 0; i < s.length(); i++) {
            if(!isVowel(s.charAt(i))) {
                res.append(s.charAt(i));
            } else {
                while(counts[j] == 0 && j < counts.length) j++;
                counts[j]--;
                res.append((char)(j + 'A'));
            }
        } 
        return res.toString();     
    }
}