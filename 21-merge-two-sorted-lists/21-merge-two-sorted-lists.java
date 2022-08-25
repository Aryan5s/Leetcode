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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode start = new ListNode(0, null );
        ListNode head = start ; 
        
        while (list1 !=  null && list2 != null ) {
            if (list1.val < list2.val ) { 
                ListNode nex = list1 ; 
                list1 = list1.next ; 
                nex.next = null ; 
                start.next = nex ;  
                start = start.next ; 
              
            }
            else if (list1.val > list2.val ) { 
                ListNode nex = list2 ; 
                list2 = list2.next ; 
                nex.next = null ; 
                start.next = nex ;  
                start = start.next ; 
                
            }
            else {
                ListNode nex1 = list2 ; 
                list2 = list2.next ; 
                nex1.next = null ; 
                start.next = nex1 ;  
                start = start.next ; 
             
                ListNode nex2 = list1 ; 
                list1 = list1.next ; 
                nex2.next = null ; 
                start.next = nex2 ;  
                start = start.next ;
                
            }
        }
        while (list1 != null){
            ListNode nex = list1 ; 
            list1 = list1.next ; 
            nex.next = null ; 
            start.next = nex ;  
            start = start.next ; 
            
        }
        while (list2 != null){
            ListNode nex = list2 ; 
            list2 = list2.next ; 
            nex.next = null ; 
            start.next = nex ;  
            start = start.next ; 
             
        }
        return head.next;
    }
}