class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums.length == 1)return 1;
        int i=0;
        int j=1;
        while(j<nums.length && i <nums.length)
            if(nums[i]==nums[j])
                j++;
            else
                nums[++i]=nums[j];
        return i+1;
    }
}