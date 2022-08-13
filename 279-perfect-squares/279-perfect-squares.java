class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp , -1);
       return solver(n , dp);
    }
    
    public int solver(int n , int[] dp ){
      if(n<=1) return n;
    
        if(dp[n] != -1){
            return dp[n];
        }
        
    int res = Integer.MAX_VALUE;
    
    int i = 1;
    
    while(i*i <= n){
      int o = 1 + solver(n-(i*i) , dp );
      res = Math.min(o,res);
      i++;
    }
    
    return dp[n] = res;
    }
   
}