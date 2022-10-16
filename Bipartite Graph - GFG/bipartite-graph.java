//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] color = new int[V];
        Arrays.fill(color , -1);
        for(int index = 0; index < V; index++){
            if(color[index] == - 1){
                if(check(index , color , adj) == false){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean check(int node , int[] color , ArrayList<ArrayList<Integer>>adj){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = 0;
        
        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            for(int it : adj.get(currentNode)){
                if(color[it] == - 1){
                    color[it] = 1 - color[currentNode];
                    queue.add(it);
                }else if(color[it] == color[currentNode]){
                    return false;
                }
            }
        }
        return true;
    }
}