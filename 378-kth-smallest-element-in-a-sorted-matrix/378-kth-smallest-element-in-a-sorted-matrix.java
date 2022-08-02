class Solution {
    public int kthSmallest(int[][] matrix, int k) {
            
       ArrayList<Integer> list = new ArrayList<>();
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col ++){
               list.add(matrix[row][col]);
            }
        }
        Collections.sort(list);
        return list.get(k - 1);
        
    }
}