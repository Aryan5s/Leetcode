class Solution {
    public boolean isPalindrome(String s) {
         StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isLetter(c)||Character.isDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        s = sb.toString();
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l++)!=s.charAt(r--)) return false;
        }
        return true;
    }
}