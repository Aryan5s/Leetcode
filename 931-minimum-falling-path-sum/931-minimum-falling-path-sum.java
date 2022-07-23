class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
//         In the row find out the min.
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int temp = memoization(n - 1, i, matrix, dp);
            ans = Math.min(ans, temp);
        }
        
        return ans;
    }
    
     public int memoization(int row , int col , int[][] arr, int[][] dp ){
        if (col < 0 || col >= arr[row].length){
            return (int) Math.pow(10,9);
        }
        if (row == 0){
            return arr[0][col];
        }

        if (dp[row][col] != - 1){
            return dp[row][col];
        }

        int straight = arr[row][col] +  memoization(row - 1, col ,arr , dp);
        int left = arr[row][col] +  memoization(row - 1, col - 1 ,arr , dp );
        int right = arr[row][col] +  memoization(row - 1, col + 1,arr , dp );

        return dp[row][col] =  Math.min(straight , Math.min(left , right));
    }
}