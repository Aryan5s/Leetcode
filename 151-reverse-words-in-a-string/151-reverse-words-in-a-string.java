class Solution {
    public String reverseWords(String s) {
      if(s.isEmpty()){
          return "";
      }
        
       String result = new String();
        int i =0; 
       while(i < s.length()){
           while(i<s.length() && s.charAt(i) == ' ') i++;
           if(i>=s.length())break;
           int j= i+1;
           while(j<s.length() && s.charAt(j) != ' ') j++;
           String sub = s.substring(i,j);
           if(result.length() == 0) result = sub;
           else result = sub + " " + result;
           i = j + 1;
       }
        return result;
    }
}