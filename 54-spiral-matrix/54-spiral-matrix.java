class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
          
        List<Integer> list = new ArrayList<>();
        
        int startCol = 0;
        int endCol =  matrix[0].length-1;
        int startRow = 0;
        int endRow = matrix.length-1;
        
        int len = (matrix[0].length * matrix.length);
        
        while(list.size() < len){
             
            for(int i = startCol; i <= endCol; i++){
                list.add(matrix[startRow][i]);
            }
            
            for(int i = startRow+1; i <= endRow; i++){
                list.add(matrix[i][endCol]);
            }
            
            for(int i = endCol-1; i >= startCol && list.size() < len; i--){
                list.add(matrix[endRow][i]);
            }
            
            for(int i = endRow-1; i > startRow && list.size() < len; i--){
                list.add(matrix[i][startCol]);
            }
            
            startCol++;
            startRow++;
            endRow--;
            endCol--;
        }
        
        return list;
    }
}