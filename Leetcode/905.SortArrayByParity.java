class Solution {
    private void swap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while(left < right) {
            if((nums[left] % 2 != 0) && (nums[right] % 2 != 1)) {
                swap(nums, left, right);
                left++;
                right--;
                continue;
            }

            if(nums[left] % 2 == 0)
                left++;

            if(nums[right] % 2 == 1)
                right--;
        }
        return nums;
    }
}