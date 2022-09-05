class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        helper(nums, visited, res, new ArrayList());
        return res;
    }
    
    public void helper(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> curr) {
        if (curr.size() == nums.length) {
            res.add(curr);
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (visited[i] == true) continue;
            else {
                visited[i] = true;
                curr.add(nums[i]);
                helper(nums, visited, res, new ArrayList(curr));
                curr.remove(curr.size() - 1);
                visited[i] = false;
				// skip the same number
                while(i + 1 < nums.length && num == nums[i + 1]) i++;
            }
        }
    }
}