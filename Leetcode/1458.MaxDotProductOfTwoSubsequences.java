class Solution {
    private int solve(int[] nums1, int[] nums2, int index1, int index2, Integer[][] dp) {
        if(index1 >= nums1.length || index2 >= nums2.length)
            return Integer.MIN_VALUE;
        if(dp[index1][index2] != null) return dp[index1][index2];
        int take =  nums1[index1]*nums2[index2] + Math.max(0, solve(nums1, nums2, index1 + 1, index2 + 1, dp));
        int skip1 =  solve(nums1, nums2, index1 + 1, index2, dp);
        int skip2 =  solve(nums1, nums2, index1, index2 + 1, dp);
        return dp[index1][index2] = Math.max(take, Math.max(skip1, skip2));

    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        Integer[][] dp = new Integer[nums1.length+1][nums2.length+1];
        return solve(nums1, nums2, 0, 0, dp);
    }
}