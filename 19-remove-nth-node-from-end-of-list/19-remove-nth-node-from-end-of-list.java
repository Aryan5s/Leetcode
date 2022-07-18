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
    public ListNode removeNthFromEnd(ListNode head, int n) {
      int length = 0;
        ListNode temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }//end while        
        temp = head;       
        if(length == n){
            head=head.next;
        }//end if
     else{
            //iterate to the node position
            for(int i=0; i<length-n-1; i++){
            temp = temp.next;
        }//end for          
        temp.next = temp.next.next;
       }//end else
       return head;
    }
}