class Solution {
    public int getWinner(int[] nums, int k) {
        int max = Math.max(nums[0], nums[1]);
        int count = 1;
        if(count == k) return max;
        for(int i = 2; i < nums.length; i++) {
            if(Math.max(nums[i], max) == max) {
                count++;
                if(count == k) return max;
            } else {
                max = nums[i];
                count = 1;
            }
        }
        return max;
    }
}