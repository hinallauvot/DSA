class Solution {
    public int[][] imageSmoother(int[][] img) {
        int M = img.length;
        int N = img[0].length;
        int[][] res = new int[M][N];
        int[][] dir = {
            {-1, 1}, {0, 1}, {1, 1},
            {-1, 0}, {0, 0}, {1, 0},
            {-1, -1}, {0, -1}, {1, -1}
        };

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                int count = 0;
                int sum = 0;
                for(int k = 0; k < 9; k++) {
                    int new_x = i + dir[k][0];
                    int new_y = j + dir[k][1];
                    if(new_x < M && new_x >= 0 && new_y < N && new_y >= 0) {
                        sum += img[new_x][new_y];
                        count++;
                    }
                }
                res[i][j] = sum/count;
            }
        }
        return res;
    }
}