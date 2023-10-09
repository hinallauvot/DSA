class Solution {
    private int find(int[] nums, int target, boolean first) {
        int low = 0, high = nums.length-1;
        int res = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                res = mid;
                if(first) high = mid -1;
                else low = mid + 1;
            } else if(nums[mid] > target) high = mid-1;
            else low = mid +1;
        }
        return res;
    }

    public int[] searchRange(int[] nums, int target) {
        int first = find(nums, target, true);
        int last = find(nums, target, false);
        return new int[]{first, last};
    }
}