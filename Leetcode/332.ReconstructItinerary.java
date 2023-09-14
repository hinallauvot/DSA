class Solution {
    List<String> path = new ArrayList<>();

    private void dfs(Map<String, List<String>> graph, String from) {
        List<String> neighbours = graph.get(from);
        //explore neighbours
        while (neighbours != null && !neighbours.isEmpty()) {
            String next = neighbours.remove(0);
            dfs(graph, next);
        }
        path.add(from);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Set<String> set = new HashSet<>();
        Map<String, List<String>> graph = new HashMap<>();
        //create graph
        for(List<String> ticket : tickets) 
            graph.computeIfAbsent(ticket.get(0), value -> new ArrayList<>()).add(ticket.get(1));
        
        //sort values in lexical order
        graph.forEach((key, value) -> Collections.sort(value));
        dfs(graph, "JFK");
        Collections.reverse(path);
        return path;
    }
}