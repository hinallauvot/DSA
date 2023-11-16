class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < nums.length; i++){
            char ch = nums[i].charAt(i);
            if(ch == '0') sb.append("1");
            else sb.append("0");
        }
        return sb.toString();
    }
}