class Solution {
    static void dfs(int val,int prev,HashMap<Integer,List<Integer>> adj,int[] arr,int idx){
        arr[idx]=val;
        for(int adjecents : adj.get(val)){
            if(prev!=adjecents){
                dfs(adjecents,val,adj,arr,idx+1);
            }
        }
        
    }
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        for(int[] edge : adjacentPairs){
            int x = edge[0];
            int y = edge[1];
            if(!adj.containsKey(x)){
                adj.put(x, new ArrayList<>());
            }
            if(!adj.containsKey(y)){
                adj.put(y, new ArrayList<>());
            }
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        int root=0;
         for(Integer map : adj.keySet()){
            if(adj.get(map).size()==1){
                root=map;
                break;
            }
        }
        int[] arr = new int[adj.size()];
        dfs(root,Integer.MIN_VALUE,adj,arr,0);
        return arr;
    }
}