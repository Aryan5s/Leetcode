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
    public TreeNode invertTree(TreeNode root) {
       if(root == null){
           return null;
       }
         
        TreeNode originalRight = root.right;
        TreeNode originalLeft = root.left;
        
        root.left = invertTree(originalRight);
        root.right = invertTree(originalLeft);
        
        return root;
    }
}