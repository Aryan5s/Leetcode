//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair{
    int vertex;
    int origin;
    
    public Pair(int vertex , int origin){
        this.vertex = vertex;
        this.origin = origin;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for(int index = 0; index < V; index++){
            if(visited[index] == false){
                if(checkCycle(index , visited , adj , V)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean checkCycle(int node , boolean[] visited , ArrayList<ArrayList<Integer>> adj , int V ){
         visited[node] = true;
         Queue<Pair> queue = new LinkedList<>();
         queue.add(new Pair(node , -1));
         
         while(!queue.isEmpty()){
             int ver = queue.peek().vertex;
             int ori = queue.peek().origin;
             queue.remove();
             
             for(int adjacentNode : adj.get(ver)){
                 if(visited[adjacentNode] == false){
                     visited[adjacentNode] = true;
                     queue.add(new Pair(adjacentNode , ver));
                 }else if(ori != adjacentNode){
                     return true;
                 }
             }
         }
         return false;
    }
    
}