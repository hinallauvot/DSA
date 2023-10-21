class Pair {
    int value;
    int index;

    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n+1];
        System.arraycopy(nums, 0, dp, 0, n);
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.value - p1.value);
        int res = nums[0];
        pq.add(new Pair(nums[0], 0));
        for(int i = 1; i < n; i++) {
            while(!pq.isEmpty() && i - pq.peek().index > k) pq.poll();
            dp[i] = Math.max(dp[i], nums[i] + pq.peek().value);
            pq.offer(new Pair(dp[i], i));
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}