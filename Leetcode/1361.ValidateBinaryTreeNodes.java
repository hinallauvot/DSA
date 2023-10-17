class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int node = 0; node < n; node++) {
            int left = leftChild[node];
            int right = rightChild[node];
            if (left != -1) {
                graph.computeIfAbsent(node, k -> new ArrayList<>()).add(left);
                inDegree[left]++;
            }
            if (right != -1) {
                graph.computeIfAbsent(node, k -> new ArrayList<>()).add(right);
                inDegree[right]++;
            }
        }

        int root = -1, rootCount = 0;
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                rootCount++;
                root = i;
            }
        }
        if(rootCount != 1) return false;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            if(graph.containsKey(node)) {
                for(int neigh : graph.get(node)) {
                    if(visited.contains(neigh))
                        return false;
                    visited.add(neigh);
                    queue.add(neigh);
                }
            }
        }
        return visited.size() == n;
    }
}