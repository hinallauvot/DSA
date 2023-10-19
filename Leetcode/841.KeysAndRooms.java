class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> que = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        que.add(0);
        visited.add(0);
        while(!que.isEmpty()) {
            Integer top = que.remove();
            if(rooms.get(top).size() > 0)
                for(int child : rooms.get(top)) 
                    if(!visited.contains(child)) {
                        visited.add(child);
                        que.add(child);
                    }       
        }
        return visited.size() == rooms.size();
    }
}