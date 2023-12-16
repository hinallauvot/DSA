class Solution {
    public boolean isAnagram(String s, String t) {
        char[] strArray1 = s.toCharArray();
        char[] strArray2 = t.toCharArray();
        
        Arrays.sort(strArray1);
        Arrays.sort(strArray2);
        
        s = new String(strArray1);
        t = new String(strArray2);
        
        if(s.equals(t))
            return true;
        else
            return false;
        
    }
}