class Graph {
    List<List<int[]>> l=new ArrayList<>();
    public Graph(int n, int[][] edges) {
        for(int i=0;i<n;i++){
            l.add(new ArrayList<>());
        }
        for(int[]e:edges){
            int u=e[0];
            int v=e[1];
            int z=e[2];
            l.get(u).add(new int[]{v,z});
        }
    }
    
    public void addEdge(int[] edge) {
        l.get(edge[0]).add(new int[]{edge[1],edge[2]});
    }
    
    public int shortestPath(int node1, int node2) {
        int[]dis=new int[l.size()];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[node1]=0;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{node1,0});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int parent=curr[0],d=curr[1];
            if(parent==node2) return d;
            for(int[]neighbour:l.get(parent)){
                int x=neighbour[0];
                int y=neighbour[1];
                if(dis[x]>dis[parent]+y){
                    dis[x]=dis[parent]+y;
                    pq.add(new int[]{x,dis[x]});
                }
            }
        }
        return -1;
    }
}
