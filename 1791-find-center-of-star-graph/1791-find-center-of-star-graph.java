class Solution {
    public int findCenter(int[][] edges) {
         int temp1count = allCheck(edges[0][0] , edges);
        int temp2count = allCheck(edges[0][1] , edges);
        
        if(temp1count == edges.length){
            return edges[0][0];
        }
     
         return edges[0][1];
    }
    
    public int allCheck(int variable , int[][] edges){
       int count = 0;
        for(int row = 0; row<edges.length; row ++){
            for(int col = 0; col <edges[row].length; col++){
                if(variable == edges[row][col]){
                    count++;
                }
            }
        }
        return count;
    }
    
}