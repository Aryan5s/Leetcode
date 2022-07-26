class Solution {
    public String removeOuterParentheses(String s) {
        if(s.isEmpty()){
            return s;
        }
        
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        
        for(int i =0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                if(!stack.isEmpty()){
                    ans.append(s.charAt(i));
                }
                stack.push(s.charAt(i));
            }else{
                if(stack.size() > 1){
                    ans.append(')');
                }
                stack.pop();
            }
        }
        return ans.toString();
    }
}