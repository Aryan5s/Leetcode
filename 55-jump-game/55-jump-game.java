class Solution {
    public boolean canJump(int[] nums) {
        int maxr = 0 + nums[0];
        for(int i = 1; i < nums.length; i++){
            if(i > maxr)
                return false;
            maxr = Math.max(maxr, i + nums[i]);
        }
        return true;
      
    }
}