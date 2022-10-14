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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Pair{
    int first;
    int second;
    int steps;
    
    public Pair(int first , int second , int steps){
        this.first = first;
        this.second = second;
        this.steps= steps;
    }
}

class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
      int[][] ans = new int[grid.length][grid[0].length];
      int[][] visited = new int[grid.length][grid[0].length];
      Queue<Pair> queue = new LinkedList<>();
      
      for(int row = 0; row < grid.length; row++){
          for(int col = 0; col < grid[row].length; col++){
              if(grid[row][col] == 1){
                  queue.add(new Pair(row , col , 0));
                  visited[row][col] = 1;
              }else{
                  visited[row][col] = 0;
              }
          }
      }
      
      int[] delRow = {-1  , 0  ,1 , 0};
      int[] delCol = {0 , 1 , 0 , -1};
      
      while(!queue.isEmpty()){
          int ro = queue.peek().first;
          int co = queue.peek().second;
          int steps = queue.peek().steps;
          queue.remove();
          ans[ro][co] = steps;
          
          for(int index = 0; index < 4; index++){
              int nRow = ro + delRow[index];
              int nCol = co + delCol[index];
              
              if(nRow >= 0 && nRow < grid.length && nCol >=0 && nCol < grid[0].length  && visited[nRow][nCol] == 0 ){
                  visited[nRow][nCol] = 1;
                  queue.add(new Pair(nRow , nCol , steps + 1));
              }
          }
          
      }
      return ans;
    }
    
}