class Solution {
    public boolean backspaceCompare(String s, String t) {
     Stack <Character> s1 = new Stack<>();
        Stack <Character> s2 = new Stack<>();
        int n1 = s.length();
        int n2 = t.length();
        for(int i=0;i<n1;i++){
            if(s.charAt(i)=='#'){
                if(!s1.isEmpty())
                s1.pop();
            }
            else {
            s1.push(s.charAt(i));
            }
        }
        for(int i=0;i<n2;i++){
            if(t.charAt(i)=='#'){
                if(!s2.isEmpty())
                s2.pop();
            }else 
            s2.push(t.charAt(i));
        }
        while(!s1.isEmpty() && !s2.isEmpty()){
            if(s1.pop()!=s2.pop()){
                return false;
            }
        }
        if(!s1.isEmpty() || !s2.isEmpty()){
            return false;
        }
        return true;
    }
}