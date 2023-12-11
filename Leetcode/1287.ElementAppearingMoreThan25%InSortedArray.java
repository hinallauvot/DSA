class Solution {
    public int findSpecialInteger(int[] arr) {
        int count = 1;
        int N = arr.length;
        if(N == 1) return arr[0];
        for(int i = 1; i < N; i++) {
            if(arr[i] == arr[i-1]) count++;
            else count = 1;
            if(count > N/4) return arr[i];
        }
        return 0;
    }
}