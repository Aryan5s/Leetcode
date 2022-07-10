class Solution {
    public List<List<Integer>> subsets(int[] arr) {
         List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for(int num : arr){
            int size = outer.size();
            for (int i = 0; i < size; i++) {
                List<Integer> inter = new ArrayList<>(outer.get(i));
                inter.add(num);
                outer.add(inter);
            }
        }
        return outer;
    }
}