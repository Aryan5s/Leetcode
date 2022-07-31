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
    public ListNode deleteDuplicates(ListNode head) {
      ListNode noDuplicatesList = new ListNode(-1);
        ListNode listNode = noDuplicatesList;
        // 1 2 2 3 3 6 9
        //             ^-^
        for (ListNode node = head; node != null; node = node.next) {
            if(node.next == null){
                listNode.next = new ListNode(node.val);
                break;
            }
            if(node.val == node.next.val){
                if(node.next.next != null){
                    if (node.next.val == node.next.next.val){
                        continue;
                    }
                }
                node = node.next;
            }
            else {
                listNode.next = new ListNode(node.val);
                listNode = listNode.next;
            }
        }
        return noDuplicatesList.next;
    }
}