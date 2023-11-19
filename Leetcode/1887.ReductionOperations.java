class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int redOp = 0;
        int curr = nums[nums.length-1];
        for(int i = nums.length - 2; i >= 0; i--){
            if(curr > nums[i])
                redOp += nums.length - i - 1;  
            curr = nums[i];
        }
            
        return redOp;
    }
}