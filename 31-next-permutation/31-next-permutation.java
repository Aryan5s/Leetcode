class Solution {
    public void nextPermutation(int[] nums) {
       int n=nums.length;
       int i,j;
    
        //searching elment num[i] which is lesser than it's right element from the end
        
        for(i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
                break;
        }
        
        //if no element found then just reverse the array e.g 3 2 1-->then reverse i.e 1 2 3
        if(i==-1)
        {
            reverse(nums,0,n-1);
        }
        else //Search element greater than the element u found in previous iteration i.e element> nums[i] in (i to n)
        {
           for(j=n-1;j>i;j--)
           {
               if(nums[j]>nums[i])
                   break;
           }
          //Swap elemet at i to element at j
            int t=nums[i];
            nums[i]=nums[j];
            nums[j]=t;
            
        //reverse the remaining element from i+1 to n
            reverse(nums,i+1,n-1);
        }
        
    }
    public void reverse(int[] nums,int i,int j)
    {
        while(i<j)
        {
            int t=nums[i];
            nums[i]=nums[j];
            nums[j]=t;
            i++;
            j--;
        }
    }
}