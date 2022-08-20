class Solution {
     HashSet<Integer>hs=new HashSet<>();
    
    public int mincostTickets(int[] days, int[] costs) {
        for(int i=0;i<days.length;i++){
            hs.add(days[i]);
        }
        int [] dp=new int [400];
        Arrays.fill(dp,-1);
        return rec(days[0],days,costs,dp);
    }
    public int rec(int cday,int[]days,int[] costs,int [] dp){
        if(cday>days[days.length-1]) return 0;
        if(dp[cday]!=-1)return dp[cday];
        
        int ans=Integer.MAX_VALUE;
        if(hs.contains(cday)){
            ans=rec(cday+1,days,costs,dp)+costs[0];
            ans=Math.min(ans,rec(cday+7,days,costs,dp)+costs[1]);
            ans=Math.min(ans,rec(cday+30,days,costs,dp)+costs[2]);
        }
        else ans= rec(cday+1,days,costs,dp);
        
        return dp[cday]=ans;
    }
}