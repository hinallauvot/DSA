class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] lastOccu = new int[26];
        int max = -1;
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(lastOccu[curr - 'a'] != 0) max = Math.max(max, i - lastOccu[curr - 'a']);
            else lastOccu[curr - 'a'] = i+1;
        }
        return max;
    }
}