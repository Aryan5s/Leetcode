class Solution {
    public String[] findRelativeRanks(int[] score) {
        int[] sortedScore = clone(score);
        Arrays.sort(sortedScore);
        String[] result = new String[score.length];
        
        for(int index = 0; index < score.length; index ++){
            if(score[index] == sortedScore[sortedScore.length - 1]){
                result[index] = "Gold Medal";
            }else  if(score[index] == sortedScore[sortedScore.length - 2]){
                result[index] = "Silver Medal";
            }else  if(score[index] == sortedScore[sortedScore.length - 3]){
                result[index] = "Bronze Medal";
            }else{
                int elIndex = binarySearch(sortedScore , score[index]  , 0 , sortedScore.length);
                result[index] = "" + (sortedScore.length - elIndex);
            }
        }
        return result;
    }
    
    public int binarySearch(int[] arr , int target , int start , int end){
        int middle = start + (end-start)/2;
        if(arr[middle] == target){
            return middle;
        }else if(arr[middle] < target){
            return binarySearch(arr , target , middle + 1 , end);
        }
        return binarySearch(arr , target , start , middle - 1);
    }
    
    public int[] clone(int[] arr){
        int[] ans = new int[arr.length];
        for(int index = 0; index < arr.length; index++){
            ans[index] = arr[index];
        }
        return ans;
    }
}