class Pair {
    int row;
    int col;
    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(0, 0));
        int i = 0;
        int N = 0;
        for(List<Integer> num : nums)
            N += num.size();
        int[] res = new int[N];
        while(!que.isEmpty()) {
            Pair p = que.poll();
            res[i++] = nums.get(p.row).get(p.col);
            if(p.col == 0 && p.row + 1 < nums.size())
                que.add(new Pair(p.row + 1, p.col));
            if(p.col+1  < nums.get(p.row).size())  
                que.add(new Pair(p.row, p.col+1)); 
        }
        return res;
    }
}