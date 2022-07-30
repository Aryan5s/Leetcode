class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
       
        Stack<Integer> stack = new Stack<>();
        
        int initialiser = 0;
        
        for(int val : pushed){
            stack.push(val);
            while(!stack.isEmpty() && stack.peek() == popped[initialiser]){
              stack.pop();
              initialiser++;
            }
        }
        return stack.isEmpty();
    }
}