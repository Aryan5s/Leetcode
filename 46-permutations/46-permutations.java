class Solution {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        recursivePermute(nums , visited , inner , outer);
        return outer;
        
    }
    
    private void recursivePermute(int[] nums , boolean[] visited , List<Integer> inner ,  List<List<Integer>> outer){
        if(inner.size() == nums.length){
            outer.add(new ArrayList<>(inner));
            return;
        }
        
        
        for(int i =0; i<nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                inner.add(nums[i]);
                recursivePermute(nums , visited , inner , outer);
                inner.remove(inner.size() - 1);
                visited[i] = false;
            }
        }
    }
}