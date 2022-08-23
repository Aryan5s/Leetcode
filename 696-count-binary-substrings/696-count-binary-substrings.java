class Solution {
    public int countBinarySubstrings(String s) {
        int counter = 0 , prev = 0 , current = 1;
        
        for(int index = 1; index < s.length(); index++){
            if(s.charAt(index) != s.charAt(index - 1)){
                counter += Math.min(prev , current);
                prev = current;
                current = 1;
            }else{
                current++;
            }
        }
        return counter += Math.min(prev , current);
    }
}