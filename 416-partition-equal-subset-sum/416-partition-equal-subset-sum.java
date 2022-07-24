class Solution {
    public boolean canPartition(int[] nums) {
         int totSum=0;
    
    for(int i=0; i<nums.length;i++){
        totSum+= nums[i];
    }
    
    if (totSum%2==1) return false;
    
    else{
        int k = totSum/2;
        int dp[][]=new int[nums.length][k+1];
        for(int row[]: dp)
        Arrays.fill(row,-1);
        return subsetSumUtil(nums.length - 1,k,nums,dp);
    } 
    }
    
    public boolean subsetSumUtil(int ind, int target,int arr[],int[][] dp){
    if(target==0)
        return true;
    
    if(ind == 0)
        return arr[0] == target;
    
    if(dp[ind][target]!=-1)
        return dp[ind][target]==0?false:true;
        
    boolean notTaken = subsetSumUtil(ind-1,target,arr,dp);
    
    boolean taken = false;
    if(arr[ind]<=target)
        taken = subsetSumUtil(ind-1,target-arr[ind],arr,dp);
        dp[ind][target]=notTaken||taken?1:0;
    return notTaken||taken;
}
}