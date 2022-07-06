class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ans[] = new int[nums.length];
        int n=nums.length;
        int pre=1;
        for (int i=0;i<n;i++)
        {
            ans[i]=pre;
            pre*=nums[i];
        }
        int post=1;
        for(int i=n-1;i>=0;i--)
        {
            ans[i]*=post;
            post*=nums[i];
        }
        return ans;
    }
}