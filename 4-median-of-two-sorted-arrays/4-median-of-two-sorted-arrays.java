class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       // First - Merge both the arrays
        
        int[] mergedArray = new int[nums1.length + nums2.length]; 
        
        int pos = 0;
        for(int i = 0; i < nums1.length; i++) {
            mergedArray[pos] = nums1[i];
            pos++;
        }
        for(int i = 0; i < nums2.length; i++) {
            mergedArray[pos] = nums2[i];
            pos++;
        }

        //  Second -  Apply sorting to merged array (I have applied insertion sort)
       Arrays.sort(mergedArray);

        // Third - Get value of median from sorted array
        
        int midPos = mergedArray.length / 2;

        double median;

        if(midPos > 0 && mergedArray.length % 2 == 0) {
            median = (mergedArray[midPos] +  mergedArray[midPos - 1]) /new Double(2);
        } else {
            median = mergedArray[midPos];
        }
        return median;
    }
}