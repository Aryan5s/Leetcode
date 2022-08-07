class Solution {
    public boolean validPartition(int[] nums) {
        Boolean[] cache = new Boolean[nums.length];
        return solve(nums, 0, cache);
    }
    
    boolean solve(int[] nums, int index, Boolean[] cache) {
        if(index == nums.length) {
            return true;
        }
        
        if(cache[index] != null) {
            return cache[index];
        }
        
        if(areEqual(nums, index) && solve(nums, index + 2, cache)) {
            return cache[index] = true;
        }
        
        if(areEqualOrConsecutive(nums, index) && solve(nums, index + 3, cache)) {
            return cache[index] = true;
        }
      
        return cache[index] = false;
    }
    
    boolean areEqual(int[] nums, int index) {
        if(index + 1 >= nums.length) {
            return false;
        }
		
        int a = nums[index], b = nums[index + 1];
        return a == b;
    }
    
    boolean areEqualOrConsecutive(int[] nums, int index) {
        if(index + 2 >= nums.length) {
            return false;
        }
		
        int a = nums[index], b = nums[index + 1], c = nums[index + 2];
        return (a == b && b == c) || (a == b - 1 && b == c - 1);
    }
}