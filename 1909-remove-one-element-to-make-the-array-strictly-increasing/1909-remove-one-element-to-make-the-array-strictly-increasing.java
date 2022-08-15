class Solution {
    public boolean canBeIncreasing(int[] nums) {
       int count=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]>=nums[i])
            {
                count++;
                if(i-2>=0 && nums[i]<=nums[i-2]){
                    nums[i] = nums[i-1];
                }
            }
            if(count>1)
            {
                return false;
            }
        }
        return true; 
    }
}