class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] prev = new Integer[rowIndex + 1];
        Arrays.fill(prev, 1);
        for(int i = 0; i <= rowIndex; i++) {
            Integer[] curr = new Integer[rowIndex + 1];
            Arrays.fill(curr, 1);
            for(int j = 1; j < i; j++) {
                curr[j] = prev[j] + prev[j-1];
            }
            prev = curr;
        }
        return Arrays.asList(prev);
    }
}