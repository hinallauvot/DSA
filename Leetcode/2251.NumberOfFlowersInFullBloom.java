class Solution {
    private int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
    
    private int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        } 
        return left;
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] res = new int[people.length];
        int totalFlowers = flowers.length;
        int[] start = new int[totalFlowers];
        int[] end = new int[totalFlowers];
        for(int i = 0; i < totalFlowers; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for(int i = 0; i < people.length; i++) {
            int validStart = upperBound(start, people[i]);
            int validEnd = lowerBound(end, people[i]);
            res[i] = validStart - validEnd;
        }
        return res;
    }
}