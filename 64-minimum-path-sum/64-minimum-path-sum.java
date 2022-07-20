class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
       for(int i =0; i<dp.length; i++){
           for(int j = 0; j<dp[i].length; j++){
               dp[i][j] = -1;
           }
       }
        return solve(grid.length - 1 , grid[0].length - 1, dp , grid);
    }
    public int solve(int row , int col , int[][] dp , int[][] grid){
        if(row == 0 && col == 0){
            return grid[row][col];
        }
        if(row < 0 || col < 0){
           return (int)Math.pow(10,9);
        }
        
        if(dp[row][col] != -1 ){
            return dp[row][col];
        }
        
        int up = grid[row][col] + solve(row - 1, col , dp , grid);
        int left = grid[row][col] + solve(row , col - 1, dp , grid);
        
        return dp[row][col] = Math.min(up,left);
    }
}