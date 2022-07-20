class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int [][]dp = new int[row][col];

        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++){
                dp[i][j] = 0;
            }
        }

        if(obstacleGrid[0][0] == 0) dp[0][0] = 1;

        for(int i=1; i < row; i++){
            if(obstacleGrid[i][0] == 0){
                dp[i][0] = dp[i-1][0];
            }
        }

        for(int i=1; i < col; i++){
            if(obstacleGrid[0][i] == 0){
                dp[0][i] = dp[0][i-1];
            }
        }

        for(int i=1; i < row; i++){
            for(int j=1; j < col; j++){
                if(obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        
        return dp[row-1][col-1];
    }
}