class Solution {
    public int maxSubArray(int[] nums) {
        int sum =0;
        int maxSum = nums[0];
        
        for(int index = 0; index < nums.length; index++){
           sum += nums[index];
            if(sum > maxSum){
                maxSum = sum;
            }
            if(sum < 0){
                sum = 0;
            }
            }
        return maxSum;
    }
}