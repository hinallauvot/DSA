class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        int alice = 0, bob = 0;
        for(int i = 1; i < n-1; i++) {
            //count the consecutive 3 A's for alice and B's for bob
            if(colors.charAt(i-1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i+1)) {
                if(colors.charAt(i) == 'A')
                    alice++;
                else
                    bob++;
            }
        }

        return alice > bob; //if alice count is greater than bob => then alice can win, else if even both count are equal then also bob wins because alice chance will come first

    }
}