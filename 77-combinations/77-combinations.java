class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(n, 0, 0, k, new ArrayList<Integer>(), results);
        return results;
    }
    private void dfs(int n, int cur, int level, int k,  List<Integer> result,  List<List<Integer>> results) {
        // base case
        if(level == k) {
            if(result.size() == k) {
                results.add(new ArrayList<>(result));
            }
            return;
        }
        
        for(int i = cur + 1; i <= n; i++) {
            result.add(i);
            dfs(n, i, level + 1, k, result, results);
            result.remove(result.size() - 1);
        }
    }
}