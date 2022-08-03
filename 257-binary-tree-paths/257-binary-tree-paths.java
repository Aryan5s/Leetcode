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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> paths = new ArrayList<>();
        if(root == null){
            return paths;
        }
        
        treePaths(root , paths , "");
        return paths;
        
    }
    
    public void treePaths(TreeNode root , ArrayList<String> paths , String str){
       if(root.left == null && root.right == null){
           paths.add(str + root.val);
           return;
       }
        
        if(root.left != null){
            treePaths(root.left  , paths , str + root.val + "->");
        }
        
         if(root.right != null){
            treePaths(root.right  , paths , str + root.val + "->");
        }
    }
}