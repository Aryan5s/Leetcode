class Solution {
  public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        f(0,s,new ArrayList<String>(),res);      
        return res;
    }
    void f(int ind, String s, ArrayList<String> temp, List<List<String>> res){
        if(ind == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = ind; i<s.length(); i++){
            if(isPalindrome(s, ind, i)){
                temp.add(s.substring(ind,i+1));
                f(i+1, s, temp, res);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    boolean isPalindrome(String s, int left, int right){
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}