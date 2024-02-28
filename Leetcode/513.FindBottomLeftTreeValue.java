/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int res = root.val;
        boolean isFirst = false;
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            isFirst = !isFirst;
            for(int i = 0; i < n; i++) {
                TreeNode top = q.remove();
                if(isFirst) {
                    res = top.val;
                    isFirst = false;
                }
                
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
            }
        }
            return res;
    }
}