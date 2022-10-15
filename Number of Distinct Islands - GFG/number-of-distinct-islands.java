//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    private void dfs(int row , int col , int[][] visited , int[][] grid , ArrayList<String> list , 
    int row0 , int col0){
        visited[row][col] = 1;
       list.add(toString(row - row0 , col -col0));
       int[] delRow = {-1 , 0 , 1 , 0};
       int[] delCol = {0 , 1 , 0 , -1};
       
       for(int index = 0; index < 4; index++){
           int nRow = row + delRow[index];
           int nCol = col + delCol[index];
           
           if(nRow >= 0 && nCol >= 0 && nRow < grid.length && nCol < grid[0].length 
           && visited[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
               dfs(nRow , nCol , visited , grid , list, row0 , col0);
           }
       }
    }
    
    private String toString(int r , int c){
        return Integer.toString(r) + " " + Integer.toString(c); 
    }

    int countDistinctIslands(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        HashSet<ArrayList<String>> st = new HashSet<>();
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                if(visited[row][col] == 0 && grid[row][col] == 1){
                    ArrayList<String> list = new ArrayList<>();
                    dfs(row , col , visited , grid , list , row , col);
                    st.add(list);
                }
            }
        }
        return st.size();
    }
}
