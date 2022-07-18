class Solution {
    public int maxScoreSightseeingPair(int[] values) {
      int max = values[0] + 0;
        int res = max +  values[1] - 1;
        
        for(int i = 1; i<values.length; i++){
            res = Math.max(res , max + values[i] - i);
            max = Math.max(max , values[i] + i);
        }
        return res;
}
}