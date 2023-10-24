class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        que.offer(root);
        while(!que.isEmpty()) {
            int size = que.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);
                max = Math.max(max, node.val);
            }
            res.add(max);
        }
        return res;
    }
}