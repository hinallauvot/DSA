class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for(int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            if(ch == 'N' || ch == 'S') {
                if(ch == 'N') y += 1;
                else y -= 1;
            } else {
                if(ch == 'W') x += 1;
                else x -= 1;
            }
            if(set.contains(x*1000 + y)) return true;
            else set.add(x*1000+y);
        }
        return false;
    }
}