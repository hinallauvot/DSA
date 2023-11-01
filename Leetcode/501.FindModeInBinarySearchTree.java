class Solution {
    public int[] findMode(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorder(root,values);

        int currVal = 0, count = 0, maxCount = 0;
        List<Integer> modes = new ArrayList<>();

        for(int val : values)
        {
            if(val == currVal)
            {
                count++;
            }
            else
            {
                currVal = val;
                count = 1;
            }
            
            if(maxCount < count)
            {
                modes = new ArrayList<>();
                maxCount = count;
            }

            if(count == maxCount)
            {
                modes.add(val);    
            }   
        }

        int[] modesArr = new int[modes.size()];
        for(int i=0;i<modes.size();i++)
            modesArr[i] = modes.get(i);
        return modesArr;
    }
    
    void inorder(TreeNode root,List<Integer> values) {
        if(root == null)
            return;
        inorder(root.left,values);
        values.add(root.val);
        inorder(root.right,values);
    }
}