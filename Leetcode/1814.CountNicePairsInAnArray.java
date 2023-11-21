class Solution {
    private int reverseNumber(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
    public int countNicePairs(int[] nums) {
        int MOD = (int)1e9+7;
        Map<Integer, Integer> map = new HashMap<>();
        int N = nums.length;
        int count = 0;
        for(int i = 0; i < N; i++) {
            int sum = nums[i] - reverseNumber(nums[i]);
            count = (count + map.getOrDefault(sum, 0)) % MOD;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}