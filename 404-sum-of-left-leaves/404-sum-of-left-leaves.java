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
     public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return getSumOfLeftLeaves(root, false);
    }
    
    public int getSumOfLeftLeaves(TreeNode node, boolean isLeft) {
        if (node.left == null && node.right == null && isLeft) {
            return node.val;
        }
        
        int sumLeft = node.left == null ? 0 : getSumOfLeftLeaves(node.left, true);
        int sumRight = node.right == null ? 0 : getSumOfLeftLeaves(node.right, false);
        return sumLeft + sumRight;
    }
}