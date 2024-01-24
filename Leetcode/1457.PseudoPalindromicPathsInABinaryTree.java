class Solution {
    int ans = 0;
    private void solve(TreeNode root, int count) {
        if(root == null) return;
        count = (count ^ (1 << root.val));
        if (root.left == null && root.right ==  null && (count & (count - 1)) == 0) ans++;
        solve(root.left, count);
        solve(root.right, count);
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        solve(root, 0);
        return ans;
    }
}