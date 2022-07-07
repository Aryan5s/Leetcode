class Solution {
    public String defangIPaddr(String address) {
          StringBuilder res = new StringBuilder();
    
    for(int i=0; i<address.length(); i++){
        char c = address.charAt(i);
        if(c=='.')
            res.append("[.]");
        else
            res.append(c);
    }
    
    return res.toString();
    }
}