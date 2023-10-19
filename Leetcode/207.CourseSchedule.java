class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        Queue<Integer> que = new LinkedList<>();
        int[] res = new int[numCourses];
        int count = 0;
        for(int[] prerequisite : prerequisites) {
            graph.computeIfAbsent(prerequisite[1], k -> new ArrayList<>()).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        for(int i = 0; i < numCourses; i++) 
            if(indegree[i] == 0) 
                que.add(i);
            
        while(!que.isEmpty()) {
            int node = que.remove();
            res[count++] = node;
            if(graph.containsKey(node)) 
                for(int child : graph.get(node)) {
                    indegree[child]--;
                    if(indegree[child] == 0) {
                        
                        que.add(child);
                    }
                }         
        }
        return count == numCourses;
    }
}