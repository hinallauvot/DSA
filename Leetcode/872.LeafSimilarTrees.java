class Solution {
    private void solve(TreeNode root, List<Integer> list) {
        if(root.left == null && root.right == null) list.add(root.val);
        if(root.left != null)
            solve(root.left, list);
        if(root.right != null)
            solve(root.right, list);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        solve(root1, list1);
        solve(root2, list2);
        return list1.equals(list2);
    }
}