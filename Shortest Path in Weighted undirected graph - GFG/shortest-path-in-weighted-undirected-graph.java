//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair
{
    int distance;
    int node;
    
    public Pair(int distance, int node)
    {
        this.distance=distance;
        this.node=node;
    }
}
class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
       ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<Pair>());
        }
        
        for(int i=0;i<m;i++)
        {
            adj.get(edges[i][0]).add(new Pair(edges[i][2],edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(edges[i][2],edges[i][0]));
        }
        
        int parent[] = new int[n+1];
        int dist[] = new int[n+1];
        for(int i=1;i<=n;i++)
        {
            parent[i]=i;
            dist[i]=(int)1e9;
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.distance-b.distance);
        
        dist[1]=0;
        pq.add(new Pair(0,1));
        
        while(!pq.isEmpty())
        {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            
            for(Pair i : adj.get(node))
            {
                int edgeWeight = i.distance;
                int adjNode= i.node;
                
                if(dis + edgeWeight < dist[adjNode])
                {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dis + edgeWeight,adjNode));
                    parent[adjNode] = node;
                }
                
            }
            
        }
        
        List<Integer> path = new ArrayList<>();
            if(dist[n]==(int)1e9) 
            {
                path.add(-1);
                return path;
            }
            
            int node = n;
            
            while(parent[node]!=node) 
            {
                path.add(node);
                node = parent[node];
            }
            path.add(1);
            
            Collections.reverse(path);
            return path;
        
    }
}