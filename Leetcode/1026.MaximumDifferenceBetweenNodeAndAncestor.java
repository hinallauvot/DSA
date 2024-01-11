class Solution {
    int diff = 0;
    private void solve(TreeNode root, int min, int max) {
        if(root == null) return;
        diff = Math.max(diff, Math.max(Math.abs(root.val - min), Math.abs(root.val - max)));
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        solve(root.left, min, max);
        solve(root.right, min, max);
    }

    public int maxAncestorDiff(TreeNode root) {
        if(root == null) return 0;
        int min = root.val, max = root.val;
        solve(root, min, max);
        return diff;
    }
}