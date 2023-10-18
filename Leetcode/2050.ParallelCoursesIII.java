//Approach 1 - Topological Sort
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[n+1];
        int[] max = new int[n+1];
        for(int[] relation : relations) {
            graph.computeIfAbsent(relation[0], k -> new ArrayList<>()).add(relation[1]);
            indegree[relation[1]]++;
        }

        for(int i = 1; i <= n; i++)
            if(indegree[i] == 0) {
                queue.add(i);
                max[i] = time[i-1];
            }
                
            
        while(!queue.isEmpty()) {
            Integer node = queue.remove();
            if(graph.containsKey(node))
                for(int child : graph.get(node)) {
                    indegree[child]--;
                    max[child] = Math.max(max[child], max[node] + time[child-1]);
                    if(indegree[child] == 0) {
                        queue.add(child);
                    }
                }
        }
        return Arrays.stream(max).max().getAsInt();
    }
}

//Approach 2 - DP
class Solution {
    private int dfs(Map<Integer, ArrayList<Integer>> graph, int index, int[] time, int[] dp) {
        if(dp[index] != 0) return dp[index];
        int max = 0;
        if(graph.containsKey(index))
            for(int child : graph.get(index))
                max = Math.max(max, dfs(graph, child, time, dp));
        return dp[index] = max + time[index - 1];       
    }
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        int[] dp = new int[n+1];
        int res = 0;
        for(int[] relation : relations) {
            graph.computeIfAbsent(relation[0], k -> new ArrayList<>()).add(relation[1]);
        }
        for(int i = 1; i <= n; i++) {
            res = Math.max(res, dfs(graph, i, time, dp));
        }
        return res;
    }
}