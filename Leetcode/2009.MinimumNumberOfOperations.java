class Solution {
     public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int count = 1; //count of unique elements in an array
        int minOp = Integer.MAX_VALUE;
        //remove duplicates in-place
        for(int i = 1; i < nums.length; i++) 
            if(nums[i] != nums[i-1])
                nums[count++] = nums[i];
        
        for (int i = 0; i < count; i++) {
            int left = i;
            int right = count - 1;
            int target = nums[i] + size - 1;
            while (right - left > 1) {
                int mid = left + (right - left)/2;
                if (nums[mid] <= target) left = mid;
                else right = mid - 1;
            }

            if (nums[right] <= target) minOp = Math.min(minOp, size - 1 - right + i);
            else minOp = Math.min(minOp, size - 1 - left + i);
        }
        return minOp;
    }
}