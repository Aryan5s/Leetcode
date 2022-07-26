class Solution {
    public int calPoints(String[] ops) {
       Stack<Integer> st=new Stack<Integer>();
        int sum=0;
        
        for(int i=0;i<ops.length;i++){
            String sample=ops[i];
            if(sample.equals("C")&&!st.isEmpty()){
                st.pop();
            }
            else if(sample.equals("D")&&!st.isEmpty()){
                st.push(st.peek()*2);
            }
            else if(sample.equals("+")){
                int temp=st.pop();
                int temp2=temp+st.peek();
                st.push(temp);
                st.push(temp2);
            }
            else{
                int temp2=Integer.valueOf(sample);
                st.push(temp2);
            }
        }
        while(!st.isEmpty()){
            sum+=st.pop();
        }
        return sum;
    }
}