class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int res = nums[k];
        int min = nums[k];
        int i = k, j = k;
        while(i > 0 || j < n-1) {
            int left = (i > 0) ? nums[i-1] : 0;
            int right = (j < n-1) ? nums[j+1] : 0;
            if(left > right) {
                i--;
                min = Math.min(min, nums[i]);
            } else {
                j++;
                min = Math.min(min, nums[j]);
            }
            res = Math.max(res, min * (j-i+1));
        }
        return res;
    }
}