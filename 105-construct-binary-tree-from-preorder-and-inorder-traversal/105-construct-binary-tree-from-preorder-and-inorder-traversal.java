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
    int preOrderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preOrderIndex = 0;
       TreeNode node = solve(preorder, inorder,  0 , inorder.length - 1);
        return node;
    }
    
    public TreeNode solve(int[] preorder , int[] inorder , int start , int end){
        if(preOrderIndex >= preorder.length || (start > end)){
            return null;
        }
        
        int element = preorder[preOrderIndex++];
        TreeNode temp = new TreeNode(element);
        int position = findPosition(inorder,element);
        
        temp.left = solve(preorder , inorder , start , position - 1);
        temp.right = solve(preorder , inorder , position + 1 , end);
        
        return temp;
    }
    
    public int findPosition(int[] inorder , int element){
        for(int i =0; i<inorder.length; i++){
            if(inorder[i] == element){
                return i;
            }
        }
        return -1;
    }
}