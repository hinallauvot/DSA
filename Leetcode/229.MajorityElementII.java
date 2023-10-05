class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0, size = nums.length, ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(count1 == 0 && ele2 != nums[i]) {
                count1 = 1;
                ele1 = nums[i];
            } else if(count2 == 0 && ele1 != nums[i]) {
                count2 = 1;
                ele2 = nums[i];
            } else if(ele1 == nums[i]) count1++;
            else if(ele2 == nums[i]) count2++;
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int num : nums) {
            if(ele1 == num) count1++;
            if(ele2 == num) count2++;
        }

        if(count1 > size/3) result.add(ele1);
        if(count2 > size/3) result.add(ele2);
        return result;
    }
}