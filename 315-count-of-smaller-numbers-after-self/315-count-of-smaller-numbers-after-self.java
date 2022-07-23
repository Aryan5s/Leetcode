class Solution {
 public List<Integer> countSmaller(int[] nums) {
        
        int n=nums.length;
        int[] a=new int[n];
        
        for(int i=0;i<n;i++)
            a[i]=i;
        
        int[] res=new int[n];
        
        mergeSort(nums,a,0,n-1,res);
            
        List<Integer> r=new ArrayList<>();
        for(int i=0;i<n;i++)
            r.add(res[i]);
        return r;
    }
    
    public void mergeSort(int[] nums,int[] a,int l,int h,int[] res){
        if(l>=h)
            return;
        
        int mid=l+(h-l)/2;
        
        mergeSort(nums,a,l,mid,res);
        mergeSort(nums,a,mid+1,h,res);
        
        merge(nums,a,l,mid,h,res);
        
    }
    
    public void merge(int[] nums,int[] a,int l,int mid,int h,int[] res){
        int leftPtr=l;
        int rightPtr=mid+1;
        
        int[] merged=new int[h-l+1];
        int k=0;
        int rightMerged=0;
        
        while(leftPtr<=mid && rightPtr<=h){
            if(nums[a[leftPtr]]>nums[a[rightPtr]]){
                rightMerged++;
                merged[k++]=a[rightPtr];
                rightPtr++;
            }
            else{
                res[a[leftPtr]]+=rightMerged;
                merged[k++]=a[leftPtr];
                leftPtr++;
            }
        }
        
        while(leftPtr<=mid){
            res[a[leftPtr]]+=rightMerged;
            merged[k++]=a[leftPtr];
            leftPtr++;
        }
        
        while(rightPtr<=h){
            merged[k++]=a[rightPtr];
            rightPtr++;
        }
        
        k=0;
        
        for(int i=l;i<=h;i++){
            a[i]=merged[k++];
        }
    }
}