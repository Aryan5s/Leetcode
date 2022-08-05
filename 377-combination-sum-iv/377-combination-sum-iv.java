class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp , - 1);
        return mem(nums,target , dp);
    }
    public int mem(int[]arr, int target, int[]dp){
        if(target<0){
            return 0;
        }
        if(target == 0){
            return 1;
        }
       
        if(dp[target] != -1){
            return dp[target];
        }
        int ans = 0;
        for(int i = 0; i<arr.length; i++){
            ans += mem(arr,target-arr[i],dp);
        }
        dp[target] = ans;
        return dp[target];
    }
}