class Solution {
    public List<String> buildArray(int[] target, int n) { 
        List<String> res = new ArrayList<>();
        int j = 0, i = 1;
        while(i <= n && j < target.length) {
            if(target[j] == i) {
                res.add("Push");
                j++;
                i++;
            } else {
                res.add("Push");
                res.add("Pop");
                i++;
            }      
            
        }
        return res;
    }
}