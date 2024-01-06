class Job {
    int start;
    int end;
    int profit;
    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

class Solution {
    private int upperBound(Job[] jobs, int index, int n) {
        int start = index + 1, end = n-1, ans = -1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(jobs[index].end <= jobs[mid].start) {
                ans = mid;
                end = mid-1;
            } else start = mid+1;
        }
        return ans;
    }

    private int solve(Job[] jobs, int index, int n, Integer[] dp) {
        if(index >= n) return 0;
        if(dp[index] != null) return dp[index];
        int take = jobs[index].profit;
        int next = upperBound(jobs, index, n);
        if(next != -1)
            take += solve(jobs, next, n, dp);
        int notTake = solve(jobs, index + 1, n, dp);
        return dp[index] = Math.max(take, notTake);
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int N = startTime.length;
        Job[] jobs = new Job[N];
        for(int i = 0; i < N; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, (job1, job2) -> job1.start - job2.start);
        Integer[] dp = new Integer[N];
        return solve(jobs, 0, N, dp);
    }
}