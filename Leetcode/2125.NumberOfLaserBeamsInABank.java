class Solution {
    public int numberOfBeams(String[] bank) {
        int noOfBeams = 0;
        int lastRowCount = 0;
        for(String row : bank) {
            int currRowCount = 0;
            for(char ch : row.toCharArray())
                if(ch == '1') currRowCount++;
            noOfBeams += lastRowCount*currRowCount;
            lastRowCount = currRowCount != 0 ? currRowCount : lastRowCount;
        }
        return noOfBeams;
    }
}