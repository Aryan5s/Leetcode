class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[][] dp = new int[row][row];
        for(int[] i : dp){
            Arrays.fill(i, - 1);
        }
        return minPathSum(dp,0,0,triangle);
    }
    
    public int minPathSum(int[][] dp , int row , int col , List<List<Integer>> triangle ){
        if(row == triangle.size() - 1){
            return triangle.get(triangle.size() - 1).get(col);
        }
        
        if(dp[row][col] != - 1){
            return dp[row][col];
        }
        
        int down = triangle.get(row).get(col) + minPathSum(dp , row+1 , col , triangle);
         int diagonal = triangle.get(row).get(col) + minPathSum(dp , row+1 , col + 1 , triangle);
        
        return dp[row][col] = Math.min(down , diagonal);
        
    }
}