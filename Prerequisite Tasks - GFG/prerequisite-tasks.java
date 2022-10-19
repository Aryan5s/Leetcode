//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N, int[][] prerequisites)
    {
        // Form a Graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < N; i++){
            adj.add(new ArrayList<>());
        }
    
    for(int row = 0; row < prerequisites.length; row++){
        adj.get(prerequisites[row][0]).add(prerequisites[row][1]);
    }
    
     int[] indegree = new int[N];
        Queue<Integer> queue = new LinkedList<>();
        for (int j = 0; j < N; j++) {
            for (int it : adj.get(j)) {
                indegree[it]++;
            }
        }

        for (int index = 0; index < indegree.length; index++) {
            if (indegree[index] == 0) {
                queue.add(index);
            }
        }
        int arrIndex = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            arrIndex++;
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }
      return arrIndex == N;
}
}