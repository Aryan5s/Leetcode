class Solution {
    public List<List<Integer>> generate(int numRows) {
       ArrayList<List<Integer>> result = new ArrayList<>();
         ArrayList<Integer> prev = null;
         ArrayList<Integer> row = null;
        
        for(int i =0; i< numRows; i++){
           row = new ArrayList<>();
            for(int j =0; j<=i; j++){
                if(j == 0 || j== i){
                    row.add(1);
                }else{
                 row.add(prev.get(j-1) + prev.get(j));
                }
            }
                prev = row;
                result.add(row);
        }
        return result;
    }
}