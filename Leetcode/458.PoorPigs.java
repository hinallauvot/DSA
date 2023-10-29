class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int i=0;
        int test = minutesToTest/minutesToDie;
        while(Math.pow(test+1, i) < buckets) i++;
        return i;
    }
}