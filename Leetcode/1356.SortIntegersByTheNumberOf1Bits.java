class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int temp[] = new int[n];
        for(int i = 0; i < n; i++){
            temp[i] = countSetBit(arr[i]) * 10001 + arr[i];
        }
        Arrays.sort(temp);
        for(int i = 0; i < n; i++){
            temp[i] %= 10001;
        }
        return temp;
    }
    public static int countSetBit(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}