class Solution {
    public int lengthOfLastWord(String s) {
        s = s.strip();
        int index = s.length() - 1;
        int count =0;
        while(index >=0){
            if(s.charAt(index) == ' '){
                return count;
            }else{
                count++;
                index--;
            }
        }
        return count;
    }
}