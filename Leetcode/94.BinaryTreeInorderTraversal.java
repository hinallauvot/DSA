\class Solution {
    List<Integer> res = new ArrayList<>();
    private void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return res;
    }
}