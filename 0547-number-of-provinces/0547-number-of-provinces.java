class Solution {
    
    private void dfs(int node , int[][] graph , boolean[] visited){
        visited[node] = true;
        for(int index = 0; index < graph[node].length; index++){
            if(visited[index] == false){
                if(graph[node][index] == 1 && index != node){
                    dfs(index , graph , visited);
                }
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
       boolean[] visited = new boolean[isConnected.length];
        int counter = 0;
        
        for(int index = 0; index < isConnected.length; index++){
            if(visited[index] == false){
                counter++;
                dfs(index, isConnected , visited);
            }
        }
        return counter;
    }        
}