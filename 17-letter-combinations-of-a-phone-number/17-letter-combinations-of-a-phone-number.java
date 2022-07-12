class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
         return padList("",digits);
    }
     public ArrayList<String> padList(String p , String up){
       ArrayList<String> list = new ArrayList<String> (); 
        if(up.isEmpty()){
            list.add(p);
            return list;   
        }
         
        int digit =(up.charAt(0)- '0')-1;
        int start = (digit-1)*3;
        int end = digit*3;
        
        if(digit==6) end+=1;
        if(digit==7) {
            start+=1;
            end+=1;
        }
        if(digit==8) {
            start+=1;
            end+=2;
        }
        for(int i=start; i<end ;i++){
            
            char ch = (char)('a'+i);
            
            list.addAll(padList((p+ch),up.substring(1)));
    
        }
        
        
        return list;
    }
}