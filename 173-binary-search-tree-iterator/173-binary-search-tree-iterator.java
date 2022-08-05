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
class BSTIterator {

    ArrayList<Integer> list = new ArrayList<>();
    int pointer = 0;
    
    public BSTIterator(TreeNode root) {
        traverse(root);
    }
    
    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }
    
    public int next() {
       int current = list.get(pointer);
        pointer++;
        return current;
    }
    
    public boolean hasNext() {
       if(pointer < list.size()){
           return true;
       }
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */