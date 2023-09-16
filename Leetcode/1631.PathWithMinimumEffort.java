public class Pair {
    int row;
    int col;
    int val;

    public Pair(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int ans = Integer.MAX_VALUE;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int[][] visited = new int[m][n];
        for(int i = 0; i < m; i++) 
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        
        pq.add(new Pair(0, 0, 0));
        visited[0][0]=heights[0][0];
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int row = p.row, col = p.col, val = p.val;

            //reached last cell (m-1, n-1)
            if(row == m-1 && col == n-1) {
                ans = Math.min(ans, val);
                return ans;
            }

            //top
            if(col-1 >= 0 && visited[row][col-1] > val) {
                visited[row][col-1] = Math.max(val, Math.abs(heights[row][col] - heights[row][col-1]));
                pq.offer(new Pair(row,col-1, visited[row][col-1]));
            }

            //bottom
            if(col+1 < n && visited[row][col+1] > val) {
                visited[row][col+1] = Math.max(val, Math.abs(heights[row][col] - heights[row][col+1]));
                pq.offer(new Pair(row,col+1, visited[row][col+1]));
            }

            //left
            if(row-1 >= 0 && visited[row-1][col] > val) {
                visited[row-1][col] = Math.max(val, Math.abs(heights[row][col] - heights[row-1][col]));
                pq.offer(new Pair(row-1,col, visited[row-1][col]));
            }

            //bottom
            if(row+1 < m && visited[row+1][col] > val) {
                visited[row+1][col] = Math.max(val, Math.abs(heights[row][col] - heights[row+1][col]));
                pq.offer(new Pair(row+1,col, visited[row+1][col]));
            }
        }

        return ans;
    }
}