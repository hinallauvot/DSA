class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        return (int)solve(cost,time,0,0,new Long[501][501]);
    }
    
    private long solve(int[] cost, int[] time, int index, int total, Long[][] dp) {
        if(total >= cost.length) return 0;
        if(index >= cost.length) return Integer.MAX_VALUE;
        if(dp[index][total] != null) return dp[index][total];
        
        long take = cost[index] + solve(cost, time, index+1, total + time[index] + 1, dp);
        long notTake = solve(cost, time, index+1, total, dp);
        return dp[index][total] = Math.min(take, notTake);
    }
}