class Solution {
    public String firstPalindrome(String[] words) {
        
        for(int i =0; i<words.length; i++){
          if(isPalindrome(words[i])){
              return words[i];
          }
        }
        return "";
    }
    
    public boolean isPalindrome(String str){
        
        if(str.isEmpty()){
            return true;
        }
        
        int start = 0;
        int end = str.length() - 1;
        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}