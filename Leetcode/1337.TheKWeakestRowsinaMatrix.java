//Approach - 1
class Pair {
    int row;
    int noOfSoldiers;

    public Pair(int row, int noOfSoldiers) {
        this.row = row;
        this.noOfSoldiers = noOfSoldiers; 
    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.noOfSoldiers - p2.noOfSoldiers  == 0 ? p1.row - p2.row : p1.noOfSoldiers - p2.noOfSoldiers);
        for(int i = 0; i < m; i++) {
            int noOfSoldiersPerRow = 0;
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1) {
                    noOfSoldiersPerRow++;
                }
            }
            pq.add(new Pair(i, noOfSoldiersPerRow));
        }

        for(int i = 0; i < k; i++) {
            res[i] = pq.remove().row;
        }

        return res;
    }
}

//Approach - 2 - Using Binary Search
class Solution {
    private int binarySearch(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == 1)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.noOfSoldiers - p2.noOfSoldiers  == 0 ? p1.row - p2.row : p1.noOfSoldiers - p2.noOfSoldiers);
        for(int i = 0; i < m; i++) {
            int noOfSoldiersPerRow = binarySearch(mat[i]);
            pq.add(new Pair(i, noOfSoldiersPerRow));
        }

        for(int i = 0; i < k; i++) {
            res[i] = pq.remove().row;
        }

        return res;
    }
}
