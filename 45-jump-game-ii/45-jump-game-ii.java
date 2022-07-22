class Solution {
    public int jump(int[] nums) {
        int res = 0, left = 0, right = 0, farthest = 0;
        while(right < nums.length-1){
            for(int i = left; i<=right; i++)
                farthest = Math.max(farthest,i+nums[i]);
            left = right + 1;
            right = farthest;
            res++;
        }
        return res;
    }
}