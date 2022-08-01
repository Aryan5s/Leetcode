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
    public ListNode insertionSortList(ListNode head) {
        int length = getLength(head);
        ListNode temp = head;
        int[] arr = new int[length];
        
        for(int index = 0; index < arr.length; index++){
            arr[index] = temp.val;
            if(temp.next != null){
                 temp = temp.next;
            }
        }
        
        Arrays.sort(arr);
        return createList(arr);
    }
    
    public ListNode createList(int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        
        for(int index = 1; index < arr.length; index++){
          ListNode node = new ListNode(arr[index]);
            temp.next = node;
            temp = node;
        }
        return head;
    }
    
    public int getLength(ListNode node){
        int length = 0;
        while(node != null){
            node = node.next;
            length+=1;
        }
        return length;
    }
    
}