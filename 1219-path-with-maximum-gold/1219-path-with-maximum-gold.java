class Solution {
    public int getMaximumGold(int[][] graph) {
        int max = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[0].length; j++) {
                max = Math.max(max, findAllPaths(graph, i, j, visited));
            }
        }
        return max;
    }
    public int findAllPaths(int[][] graph, int i, int j, boolean[][] visited) {
        int ans = 0;
        if(i < 0 || j < 0 || i >= graph.length || j >= graph[0].length || visited[i][j]) {
            return ans;
        }
        if(graph[i][j] == 0) return 0;
            
        visited[i][j] = true;
        
        int right = findAllPaths(graph, i + 1, j, visited); 
        int left = findAllPaths(graph, i - 1, j, visited);
        int up = findAllPaths(graph, i, j + 1, visited);
        int down = findAllPaths(graph, i, j - 1 , visited);
        
        ans = graph[i][j] + Math.max(Math.max(left, right),Math.max(up, down));
        visited[i][j] = false;

        return ans;
    }
}