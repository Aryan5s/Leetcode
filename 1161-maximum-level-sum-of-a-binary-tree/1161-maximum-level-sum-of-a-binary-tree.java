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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        int lvl=0;
        int flvl=0;
        int finals=Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int s=q.size();
            lvl++;
            int sum=0;
            while(s>0){
                TreeNode cur=q.remove();
                sum=sum+cur.val;
                if(cur.left!=null){q.add(cur.left);}
                if(cur.right!=null){q.add(cur.right);}
                s--;
            }
            if(sum>finals){
                finals=sum;
                flvl=lvl;
            }
        }
        return flvl;
        
    }
}