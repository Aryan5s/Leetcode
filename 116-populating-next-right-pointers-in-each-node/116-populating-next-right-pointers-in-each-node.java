/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null; // edge case
        if (root.left == null) return root; // edge case 
        connectLeft(root); // connect all left children 
        connectRight(root); // connect all right children
        return root;
    }

    private void connectLeft(Node node) {
        if (node.left == null) return;
        node.left.next = node.right;
        connectLeft(node.left);
        connectLeft(node.right);
    }

    private void connectRight(Node node) {
        if (node.right == null) return;
        if (node.next != null) node.right.next = node.next.left;
        connectRight(node.right);
        connectRight(node.left);
    }
}