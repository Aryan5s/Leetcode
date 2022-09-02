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
    public List<Double> averageOfLevels(TreeNode root) {
	//preparing list for final ans
        List<Double> list = new ArrayList<>();
		//if root is null return empty list
        if(root == null) return list;
		//declaring a queue for maintaining nodes at each level
        Queue<TreeNode> q = new LinkedList<>();
		//insert root first
        q.offer(root);
		//go through the queue till it is empty
        while(!q.isEmpty()){
		//calculate the present size of queue and sum variable for calculating the sum of nodes in that level
            double size = q.size();
            double sum = 0;
			//iterate through present level
            for(int i=0; i<size;i++){
			//push out the present node
                TreeNode temp = q.poll();
				//add its val to the sum variable
                sum+=temp.val;
				//add left and right children to queue if they exist
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
            }
			//add average value to list and return list at the end
            list.add(sum/size);
        }
        return list;
    }
}