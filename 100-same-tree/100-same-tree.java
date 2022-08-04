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
       
         ArrayList<Integer> list1 = new ArrayList<>();
         ArrayList<Integer> list2 = new ArrayList<>();
        createList(p,list1);
        createList(q,list2);
        return list1.equals(list2);
    }
    
    public void createList(TreeNode node , ArrayList<Integer> list){
        if(node == null){
           list.add(-1);
            return;
        }
        list.add(node.val);
        createList(node.left , list);
        createList(node.right , list);
    }
}