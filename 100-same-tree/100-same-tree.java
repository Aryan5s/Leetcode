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
    public boolean isSameTree(TreeNode p, TreeNode q) {
      
        if(p == null && q == null){
            return true;
        }
    
        if( (p == null && q != null) || (p != null && q == null)){
            return false;
        }
        
       if(p.val != q.val) return false;
        boolean leftTreeMatch = isSameTree(p.left, q.left);
        boolean rightTreeMatch = isSameTree(p.right, q.right);
        
        return leftTreeMatch && rightTreeMatch;
    }
}