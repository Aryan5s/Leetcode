class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer , Integer> num_counts = new HashMap();
        int degree = 0;
        
         HashMap<Integer , Integer> firstSeen = new HashMap();
          int minLength = 0;
        
        for(int index = 0; index < nums.length; index++){
            
            firstSeen.putIfAbsent(nums[index] , index);
            num_counts.put(nums[index] , num_counts.getOrDefault(nums[index] , 0) + 1);
            
            if(num_counts.get(nums[index]) > degree){
                degree = num_counts.get(nums[index]);
                minLength = index - firstSeen.get(nums[index]) + 1;
                
            }else if (num_counts.get(nums[index]) == degree){
             minLength = Math.min(minLength , index  - firstSeen.get(nums[index]) + 1);
            }
        }
        
        return minLength;
    } 
}
