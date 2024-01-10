class Solution {
    private void createGraph(Map<Integer, List<Integer>> graph, TreeNode root) {
        if(root == null) return;
        if(root.left != null) {
            graph.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.left.val);
            graph.computeIfAbsent(root.left.val, k -> new ArrayList<>()).add(root.val);
            createGraph(graph, root.left);
        }
        if(root.right != null) {
            graph.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.right.val);
            graph.computeIfAbsent(root.right.val, k -> new ArrayList<>()).add(root.val);
            createGraph(graph, root.right);
        }
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        createGraph(graph, root);
        Queue<Integer> que = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int res = 0;
        que.add(start);
        visited.add(start);
        while(!que.isEmpty()) {
            int n = que.size();
            while(n-- > 0) {
                int curr = que.poll();
                if(graph.containsKey(curr))
                    for(int neigh : graph.get(curr)) {
                        if(!visited.contains(neigh)) {
                            que.add(neigh);
                            visited.add(neigh);
                        }
                    }   
            }
            res++;
        }
        return res-1;
    }
}