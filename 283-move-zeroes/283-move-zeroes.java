class Solution {
    public void moveZeroes(int[] nums) {
       
        int non_zero = 0;
        int zeros = 0;
        
        while(non_zero < nums.length){
            if(nums[non_zero] != 0){
                nums[zeros] = nums[non_zero];
                zeros++;
            }
            non_zero++;
        }
        
        while(zeros < nums.length){
            nums[zeros] = 0;
            zeros++;
        }
        
    }
}