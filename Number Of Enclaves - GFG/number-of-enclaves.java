//{ Driver Code Starts
// Initial Template for Java

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
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    private void dfs(int ro, int co , int[][] grid , boolean[][] visited , int[] delRow , int[] delCol ){
        visited[ro][co] = true;
        
        for(int index = 0; index < 4; index++){
            int nRow = ro + delRow[index];
            int nCol = co + delCol[index];
            if(nRow >= 0 && nCol >=0 && nRow < grid.length && nCol < grid[0].length &&
            visited[nRow][nCol] == false && grid[nRow][nCol] == 1){
                dfs(nRow , nCol , grid , visited , delRow , delCol);
            }
        }
    }

    int numberOfEnclaves(int[][] grid) {
     int counter = 0;
     boolean[][] visited = new boolean[grid.length][grid[0].length];
      int[] delRow = {-1 , 0 , 1 ,0};
      int[] delCol = {0 , 1 ,0 , -1};
      
      for(int firstCol = 0; firstCol < grid[0].length; firstCol++){
        //   Traverse first row
          if(visited[0][firstCol] == false && grid[0][firstCol] == 1){
              dfs(0 , firstCol , grid , visited , delRow , delCol);
          }
          
        //   Traverse Last Row
         if(visited[grid.length - 1][firstCol] == false && grid[grid.length - 1][firstCol] == 1){
              dfs(grid.length - 1 , firstCol , grid , visited , delRow , delCol);
          }
          
      }
      
       for(int firstRow = 0; firstRow < grid.length; firstRow++){
        //   Traverse first row
          if(visited[firstRow][0] == false && grid[firstRow][0] == 1){
              dfs(firstRow , 0 , grid , visited , delRow , delCol);
          }
          
        //   Traverse Last Row
         if(visited[firstRow][grid[0].length - 1] == false && grid[firstRow][grid[0].length - 1] == 1){
              dfs(firstRow , grid[0].length - 1 , grid , visited , delRow , delCol);
          }
      }
      
      
      for(int row = 0; row < grid.length; row ++){
          for(int col = 0; col < grid[row].length; col++){
              if(visited[row][col] == false && grid[row][col] == 1){
                  counter++;
              }
          }
      }
       return counter;
    }
}