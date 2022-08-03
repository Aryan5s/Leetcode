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
class Solution 
{
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        pathSum(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }
    
    public void pathSum(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> ans)
    {
        if(root == null)
            return;
        path.add(root.val);
        if(root.left == null && root.right == null && targetSum == root.val)
        {
            ans.add(new ArrayList(path));
        }
        else
        {
            pathSum(root.left, targetSum-root.val, path, ans);
            pathSum(root.right, targetSum-root.val, path, ans);
        }
        path.remove(path.size()-1); 
    }
}