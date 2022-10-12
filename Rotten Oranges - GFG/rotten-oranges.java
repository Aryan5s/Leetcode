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
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Pair{
    int first;
    int second;
    int initial;
    
    public Pair(int first , int second , int initial){
        this.first = first;
        this.second = second;
        this.initial = initial;
    }
}

class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
       int[][] visited = new int[grid.length][grid[0].length];
       int freshCount = 0;
       Queue<Pair> queue = new LinkedList<>();
       for(int row = 0; row < grid.length; row++){
           for(int col = 0; col < grid[row].length; col++){
               if(grid[row][col] == 2){
                    queue.add(new Pair(row , col , 0));
                   visited[row][col] = 2;
               }else if(grid[row][col] == 0){
                   visited[row][col] = 0;
               }else{
                   freshCount++;
               }
           }
       }
       int time = 0;
       int[] delrow = {-1 , 0  , 1 , 0};
       int[] delcol = {0 , 1 , 0 , -1};
       int count = 0;
       
       while(!queue.isEmpty()){
           int first = queue.peek().first;
           int second = queue.peek().second;
           int t = queue.peek().initial;
           time = Math.max(time , t);
           queue.remove();
           
           for(int index = 0; index < 4; index++){
               int nRow = first + delrow[index];
               int nCol = second + delcol[index];
               if(nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length 
               && visited[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                   queue.add(new Pair(nRow , nCol , t + 1));
                   visited[nRow][nCol] = 2;
                   count++;
               }
           }
       }
       
       if(freshCount != count) return -1;
       return time;
    }
    
}