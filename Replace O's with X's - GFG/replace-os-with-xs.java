//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    private static void dfs(int row , int col , int[][] visited ,char a[][] , int[] delRow , int[] delCol){
        visited[row][col] = 1;
        for(int index = 0; index < 4; index++){
            int nRow = row + delRow[index];
            int nCol = col + delCol[index];
            
            if(nRow >= 0 && nRow < a.length && nCol >= 0 && nCol < a[0].length &&
            visited[nRow][nCol] == 0 && a[nRow][nCol] == 'O'){
                visited[nRow][nCol] = 1;
                dfs(nRow , nCol , visited , a , delRow , delCol);
            }
        }
    }
    
    
    static char[][] fill(int n, int m, char a[][])
    {
        int[] delRow = {-1 , 0  , 1 , 0};
        int[] delCol = {0 , 1 , 0 , -1};
        int[][] visited = new int[n][m];
        
        // Traverse First Row
        for(int firstCol = 0; firstCol < m; firstCol++){
            if(visited[0][firstCol] == 0 && a[0][firstCol] == 'O'){
                dfs(0 , firstCol , visited , a , delRow  , delCol);
            }
            
             if(visited[n - 1][firstCol] == 0 && a[n - 1][firstCol] == 'O'){
                dfs(n - 1 , firstCol , visited , a , delRow  , delCol);
            }
        }
        
         for(int firstRow = 0; firstRow < n; firstRow++){
            if(visited[firstRow][0] == 0 && a[firstRow][0] == 'O'){
                dfs(firstRow, 0 , visited , a , delRow  , delCol);
            }
            
             if(visited[firstRow][m - 1] == 0 && a[firstRow][m - 1] == 'O'){
                dfs(firstRow, m - 1, visited , a , delRow  , delCol);
            }
        }
        
        for(int row = 0; row < a.length; row++){
            for(int col = 0; col < a[row].length; col++){
                if(visited[row][col] == 0 && a[row][col] == 'O'){
                    a[row][col] = 'X';
                }
            }
        }
        return a;
    }
}