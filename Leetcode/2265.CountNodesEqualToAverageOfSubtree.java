class Solution {
    int res = 0;
    private int[] solve(TreeNode root) {
        if(root == null) return new int[]{0, 0}; //{sum, no of nodes}
        int rootVal = root.val;
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        int avg = (left[0] + right[0] + rootVal) / (left[1] + right[1] + 1);
        if( avg == rootVal) res++;
        return new int[] {left[0] + right[0] + rootVal, left[1] + right[1] + 1};
    }
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return res;
    }
}