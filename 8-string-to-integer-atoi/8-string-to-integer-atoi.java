class Solution {
    public int myAtoi(String str) {
      
        str = str.trim();
        
       
        if(str == null || str.length() == 0) {
            return 0;
        }
        
      
        double result = 0;
        
        
     
        boolean isNegative = false;
        int startIndex = 0;
        
        if(str.charAt(0) == '+' || str.charAt(0) == '-') {
            ++startIndex;
        }
        
        if(str.charAt(0) == '-') {
            isNegative = true;
        }
        
        
        for(int i = startIndex; i < str.length(); i++) {
           
            if(str.charAt(i) < '0' || str.charAt(i) > '9') { 
                break;
            }
            int digitValue = (int)(str.charAt(i) - '0');
            result = result*10 + digitValue;
        }
        
        
        if(isNegative) {
            result = -result;
        }
        
      
        if(result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        if(result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
       
        return (int)result;
      
        
    }
}