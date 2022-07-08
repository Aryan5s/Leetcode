class Solution {
    public int repeatedStringMatch(String a, String b) {
        if(b.isEmpty()){
            return 0;
        }
        
        StringBuilder res= new StringBuilder();
        int count=0;
        while(res.length()<b.length()){
            res.append(a);
            count++;
        } 
        if (res.toString().contains(b)) return count;
        if(res.append(a).toString().contains(b)) return ++count;
        return -1;
    }
    }
