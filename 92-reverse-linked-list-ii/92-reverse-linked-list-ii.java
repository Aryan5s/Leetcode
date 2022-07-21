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
    public ListNode reverseBetween(ListNode head, int left, int right) {
         if (left == right){
          return head;
      }

      // skip the first left - 1 nodes
       ListNode present = head;
       ListNode previous = null;
       for (int i = 0; present != null &&  i < left - 1; i++) {
            previous = present;
            present = present.next;
        }

        ListNode last = previous;
        ListNode newEnd = present;
        ListNode next = present.next;
       // reverse between left and right
        for (int i = 0;  present != null && i < right - left + 1; i++) {
            present.next = previous;
            previous = present;
            present = next;
            if (next != null){
                next = next.next;
            }
        }
        if (last != null){
            last.next = previous;
        }else {
            head = previous;
        }
        newEnd.next = present;
        return head;
    }
}