class Solution {
     public void dfs(int vertex,int [][] graph,boolean []vis){
        vis[vertex]=true;
        for(int i=0;i<graph[vertex].length;i++){
            if(vis[i]) continue;
            if(i!=vertex && graph[vertex][i]==1) dfs(i,graph,vis);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean vis[]=new boolean[isConnected.length];
        int ans=0;
        for(int i=0;i<isConnected.length;i++){
            if(vis[i]) continue;
            ans+=1;
            dfs(i,isConnected,vis);
        }
        return ans;
    }        
}