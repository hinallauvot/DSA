class Pair{
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    private boolean isBorder(int i, int j, int m , int n) {
        return i == 0 || i == m-1 || j == 0 || j == n-1;
    }

    private boolean isValid(int i, int j, int m , int n) {
        return i >=0 && i < m && j >= 0 && j < n;
    }

    private void bfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        q.offer(new Pair(i, j));

        while(q.size() > 0) {
            Pair p = q.remove();
            i = p.row;
            j = p.col;

            for(int k = 0; k < 4; k++) {
                int r1 = delrow[k], c1 = delcol[k];
                if(isValid(i+r1, j+c1, m, n) && board[i+r1][j+c1] == 'O') {
                    board[i+r1][j+c1] = '1';
                    q.offer(new Pair(i+r1, j+c1));
                }       
            }
        }

    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O' && isBorder(i, j, m, n)) {
                    board[i][j] = '1';
                    bfs(board, i, j);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                   board[i][j]='X';
                }
                else if(board[i][j]=='1'){
                    board[i][j]='O';
                }
            }
         }
    }
}