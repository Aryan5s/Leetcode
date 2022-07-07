class Solution {
    public int[] twoSum(int[] numbers, int target) {
         
    int start=0, end = numbers.length-1;
    
    while ( start <= end){
        
        int sum = numbers[start] + numbers[end];
        
        if ( target == sum){
            return new int[]{start+1, end+1};
        }
        if(sum < target){
        start ++;
        } else{
        end--; 
        }
        

    }
    
    return new int[]{};
    }
}