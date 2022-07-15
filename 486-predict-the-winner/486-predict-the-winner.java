class Solution {
    
// //      int findPlayer1Score(int i, int j, vector<int> &nums){
        
//         if(i > j)
//             return 0;
        
//         if(i == j)
//             return nums[i];
        
        
//         int way1 = nums[i] + min(findPlayer1Score(i + 2, j, nums),
//                                  findPlayer1Score(i + 1, j - 1, nums));
        
//         int way2 = nums[j] + min(findPlayer1Score(i + 1, j - 1, nums),
//                                  findPlayer1Score(i, j - 2, nums));
        
//         return max(way1, way2);
        
//     }
//     bool PredictTheWinner(vector<int>& nums) {
//         int n = nums.size();
//         int player1Score = findPlayer1Score(0, n - 1, nums);
//         int totalScore = 0;
//         for(int i = 0; i < n; i++)
//             totalScore += nums[i];
//         int player2Score = totalScore - player1Score;
        
//         return pla
    
    
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