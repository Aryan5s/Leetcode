class Solution {
    public int removeElement(int[] nums, int val) {
         int count = 0;
        
        for (int i = 0; i < nums.length; i++) {                     
            if(count > 0) nums[i-count] = nums[i];
            if(nums[i] == val) count++;
        }
        
        return nums.length - count;
    }
}