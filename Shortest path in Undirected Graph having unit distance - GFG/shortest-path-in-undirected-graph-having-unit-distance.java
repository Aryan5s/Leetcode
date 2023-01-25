//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int j = 0; j < m; j++){
            adj.get(edges[j][0]).add(edges[j][1]);
            adj.get(edges[j][1]).add(edges[j][0]);
        }
        int[] distance = new int[n];
        Arrays.fill(distance , Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        distance[src] = 0;
        queue.add(src);
        while(!queue.isEmpty()){
            int node = queue.remove();
            for(int adjacent : adj.get(node)){
                if(distance[node] + 1 < distance[adjacent]){
                    distance[adjacent] = distance[node] + 1;
                    queue.add(adjacent);
                }
            }
        }
        
        for(int index = 0; index < distance.length; index++){
            if(distance[index] == Integer.MAX_VALUE) distance[index] = -1;
        }
        
        return distance;
    }
}