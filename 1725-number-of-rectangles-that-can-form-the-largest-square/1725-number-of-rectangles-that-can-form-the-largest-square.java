class Solution {
    public int countGoodRectangles(int[][] rectangles) {
       int[] arr = new int[rectangles.length];
       for(int i =0; i<rectangles.length; i++){
           arr[i] = Math.min(rectangles[i][0], rectangles[i][1]);
       }
        int max = maxi(arr);
        int count = 0;
        for(int i =0; i<arr.length; i++){
            if(arr[i] == max){
               count++;
            }
        }
        return count;
    }
    
    public int maxi(int[] arr){
        int ans = Integer.MIN_VALUE;
        for(int i =0; i<arr.length; i++){
            if(arr[i] > ans){
                ans = arr[i];
            }
        }
        return ans;
    }
}