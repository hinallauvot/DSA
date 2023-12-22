public class Solution {
    public int maxScore(String s) {
        int max = 0;
        int left0s = 0;
        int right1s = (int) s.chars().filter(ch -> ch == '1').count();
        for (int i = 0; i < s.length() - 1; i++) {
            left0s += s.charAt(i) == '0' ? 1 : 0;
            right1s -= s.charAt(i) == '1' ? 1 : 0;
            max = Math.max(max, left0s + right1s);
        }
        return max;
    }
}