class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int count = 1; //count the no of monsters killed
        int N = dist.length;
        for(int i = 0; i < N; i++) 
            dist[i] = (int)Math.ceil((float)dist[i]/speed[i]); //reusing the dist array to calculate time => time = dist/speed
        Arrays.sort(dist); //sort according to time
        for(int i = 1; i < N; i++) {
            if(dist[i] - i <= 0) //if time is less than or equal to curr time, then monster will kill => return count till now
                return count;
            count++;
        } 
        return count;
    }
}