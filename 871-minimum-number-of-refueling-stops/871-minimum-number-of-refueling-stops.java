class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
           int n = stations.length;
        long[] dp = new long[n+1];
        dp[0] = startFuel;
        
        for(int i=0; i<n; i++){
            for(int ref = i; ref >= 0 && dp[ref] >= stations[i][0]; ref--){
                dp[ref+1] = Math.max(dp[ref+1], dp[ref] + stations[i][1]);
            }
        }
        
        for(int i=0; i<=n; i++){
            if(dp[i]>=target) return i;
        }
        
        return -1;
    }
}