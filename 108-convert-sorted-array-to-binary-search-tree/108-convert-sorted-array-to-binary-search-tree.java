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
    public TreeNode sortedArrayToBST(int[] nums) {
     if(nums.length == 0){
         return null;
     }
        return helper(nums , 0 , nums.length-1);
    }
    
    public TreeNode helper( int[] nums , int start , int end){ 
       if(start > end){
           return null;
       }
        int middle = start + (end-start)/2;
        int element = nums[middle];
        TreeNode root = new TreeNode(element);
        
        root.left = helper(nums , start , middle -1);
        root.right = helper(nums , middle + 1 , end);
        
        return root;
    }
}