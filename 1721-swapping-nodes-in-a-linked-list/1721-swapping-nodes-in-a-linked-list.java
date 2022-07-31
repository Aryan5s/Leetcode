/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
   public int size(ListNode head){
    if(head==null){
        return 0;
    }
    return size(head.next)+1;
}
public ListNode swapNodes(ListNode head, int k) {
    int n=size(head);
   ArrayList<Integer> arr=new ArrayList<Integer>();
    ListNode curr=head;
	// Putting All the value in the arrayList
    while(curr !=null ){
        arr.add(curr.val);
        curr=curr.next;
    }
	// Swaping the value
    Collections.swap(arr,n-k,k-1);
	
	// Creating the arralist value in the form of Nodes
	
    ListNode node=new ListNode(0);
    ListNode res=node;
    for(int i=0;i<arr.size();i++){
        ListNode temp=new ListNode(arr.get(i));
        res.next=temp;
        res=res.next;
    }
    return node.next;
        
}
   
}