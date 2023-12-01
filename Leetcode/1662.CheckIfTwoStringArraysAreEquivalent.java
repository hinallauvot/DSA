class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for(String word : word1)
            sb1.append(word);
        for(String word : word2)
            sb2.append(word);
        return sb1.toString().equals(sb2.toString());  
    }
}