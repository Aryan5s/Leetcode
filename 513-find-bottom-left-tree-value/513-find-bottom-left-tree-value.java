/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
       return bfs(root); 
    }
    public int bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int leftMost = root.val;
        
        while(!queue.isEmpty()){
           int size = queue.size(); 
            for(int index = 0; index < size; index ++){
               TreeNode node = queue.poll();
                if (index == 0) {
                    leftMost = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                } 
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return leftMost;
    }
}