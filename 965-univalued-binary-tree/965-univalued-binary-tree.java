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
    public boolean isUnivalTree(TreeNode root) {
        if(null==root) return false;
        int val=root.val;
        return dfs(root,val);
    }
    boolean dfs(TreeNode root,int val){
        if(null==root) return true;
        if(root.val!=val) return false;
        boolean l=dfs(root.left,val);
        boolean r=dfs(root.right,val);
        return l&&r;
    }
}