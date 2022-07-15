class Solution {
    
    public boolean PredictTheWinner(int[] nums) {
        int totalScore = 0;
        int player1Score = find(0,nums.length-1,nums);
        int player2Score = 0;
        for(int element : nums){
            totalScore += element;
        }
        player2Score = totalScore - player1Score;
        return player1Score >= player2Score;
    }
    
  public int find(int start , int end , int[] nums){
      
      if(start > end){
          return 0;
      }
      
      if(start == end){
          return nums[start];
      }
      
      int way1 = nums[start] + Math.min(find(start + 2 , end, nums) , find(start + 1, end -1 , nums));
      int way2 = nums[end] + Math.min(find(start , end - 2, nums) , find(start + 1,end - 1 ,nums));
      
      return Math.max(way1,way2);
      
      
      
      
  }
    
}