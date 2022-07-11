class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         Arrays.sort(nums);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
         int start = 0;
         int end =0;
        for(int i =0; i<nums.length; i++){
            start = 0;
         // if my current and previous element is same,then start = end + 1
            if (i>0 && nums[i] == nums[i-1]){
                start = end + 1;
            }
            end = outer.size() - 1;
            int size = outer.size();
            for (int j = start; j < size; j++) {
                List<Integer> inter = new ArrayList<>(outer.get(j));
                inter.add(nums[i]);
                outer.add(inter);
            }
        }
        return outer;
    }
}