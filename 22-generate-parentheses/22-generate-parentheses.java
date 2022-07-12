class Solution {
    public List<String> generateParenthesis(int n) {
        return brackets("", n, 0, 0, 0);
    }
    
     public ArrayList<String> brackets(String up, int n, int open, int close, int i) {
        if (i == 2 * n) {
            ArrayList<String> list = new ArrayList<>();
            list.add(up);
            return list;
        }
         
         ArrayList<String> ans = new ArrayList<>();
         
//  Adding opening brackets
        if (open < n) {
           ans.addAll(brackets(up + '(', n, open + 1, close, i + 1));
        }

//  Adding closing brackets
        if (close < open) {
           ans.addAll(brackets(up + ')', n, open, close + 1, i + 1));
        }

         return ans;
    }

}