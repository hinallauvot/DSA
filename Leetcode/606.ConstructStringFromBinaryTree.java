class Solution {
    StringBuffer sb = new StringBuffer();
    private void preOrder(TreeNode root) {
        sb.append(root.val);
        if(root.left != null) {
            sb.append("(");
            preOrder(root.left);
            sb.append(")");
        }
        if(root.right != null) {
            if(root.left == null)
                sb.append("()");
            sb.append("(");
            preOrder(root.right);
            sb.append(")");
        }
    }
    public String tree2str(TreeNode root) {
        preOrder(root);
        return sb.toString();
    }
}