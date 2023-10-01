class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(String str1 : str) {
            StringBuilder sb2 = new StringBuilder(str1);
            sb2.reverse();
            result.append(sb2.toString());
            result.append(" ");
        }
        result.deleteCharAt(result.length() -1);
        return result.toString();
    }
}