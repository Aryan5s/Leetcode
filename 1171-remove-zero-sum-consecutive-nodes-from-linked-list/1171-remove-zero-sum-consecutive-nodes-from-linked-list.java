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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode head1 = new ListNode();
        head1.next = head;
        ListNode prev = head1;
        ListNode temp = head;
        
        while(temp != null){
            ListNode node = SkipZeroSum(temp);
            if(node != temp){
                prev.next = node;
                temp = node;
            }else{
                prev = temp;
                temp = temp.next;
            }
        }
        return head1.next;
    }
    
    public ListNode SkipZeroSum(ListNode node){
        
        int sum =0;
        ListNode temp = node;
        
        while(temp!=null)
        {
            sum+=temp.val;
            if(sum==0)
            {return temp.next;}
            else
            {temp=temp.next;}
        }
        return node;
    }
}