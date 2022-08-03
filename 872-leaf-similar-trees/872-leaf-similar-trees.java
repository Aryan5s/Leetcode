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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
         ArrayList<Integer> list2 = new ArrayList<>();
        fillArray(root1 , list1);
        fillArray(root2 , list2);
        return list1.equals(list2);
    }
    public void fillArray(TreeNode node ,  ArrayList<Integer> list){
        
        if(node == null){
            return;
        }
        
        if(node.left == null && node.right == null){
            list.add(node.val);
            return;
        }
        fillArray(node.left , list);
        fillArray(node.right , list);
    }
}