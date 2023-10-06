class Pair {
    int i;
    int j;
    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] moves = new int[][] {{-1, -1}, {-1, 0}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {1, -1}, {-1, 1}};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));

        for(int count = 1; !q.isEmpty(); count++) {
            int size = q.size();
            for(int k = 0; k < size; k++) {
                Pair p = q.remove();
                if(p.i == n-1 && p.j == m-1) return count;

                for(int[] move : moves) {
                    int delx = move[0] + p.i;
                    int dely = move[1] + p.j;

                    if(delx >= 0 && delx < n && dely >= 0 && dely < m && !visited[delx][dely] && grid[delx][dely] == 0) {
                        visited[delx][dely] = true;
                        q.add(new Pair(delx, dely));
                    }

                }
            }
        }

        return -1;
    }
}