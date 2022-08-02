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
    int goodNodes = 0;
    public int goodNodes(TreeNode root) {
        counter(root , Integer.MIN_VALUE);
        return goodNodes;
    }
    
    public void counter(TreeNode root , int maxValue){
        if(root == null){
            return;
        }
        
        if(root.val >= maxValue){
            goodNodes+=1;
        }
        maxValue = Math.max(maxValue , root.val);
    
        counter(root.left , maxValue);
        counter(root.right , maxValue);
    }
    
}