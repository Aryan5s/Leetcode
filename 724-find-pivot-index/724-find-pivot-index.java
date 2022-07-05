class Solution {
    public int pivotIndex(int[] nums) {     
      int totalSum =0;
       int leftsum = 0;
         int rightsum = 0;
        for(int element : nums){
            totalSum += element;
        }
       
        for(int i =0; i<nums.length; i++){
            rightsum = totalSum - nums[i] - leftsum;
            if(rightsum == leftsum){
                return i;
            }
            leftsum += nums[i];
        }
        
        return -1;
    }
}