class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int horDist = Math.abs(fx - sx);
        int vertDist = Math.abs(fy - sy);
        if(fx == sx && fy == sy && t == 1) return false;
        return t >= Math.max(horDist, vertDist);
    }
}