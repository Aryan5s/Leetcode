class Solution {
    public int rob(int[] nums) {
      if(nums == null){
          return 0;
      }
        if(nums.length == 1){
            return nums[0];
        }
        
        int prev2 = 0;
        int prev1 = nums[0];
        
        for(int i =1 ;i<nums.length; i++){
            int current = Math.max(prev2 + nums[i] , prev1);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}