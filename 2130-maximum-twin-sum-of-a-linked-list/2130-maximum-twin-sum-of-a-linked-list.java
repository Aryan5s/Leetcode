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
    public int pairSum(ListNode head) {
        int length = getLength(head);
        ListNode temp = head;
        int[] arr = new int[length];
        
        for(int index = 0; index < arr.length; index++){
           arr[index] = temp.val;
            if(temp.next != null){
                temp = temp.next;
            }
        }
        return binarySearch(arr , 0 , arr.length - 1);
    }
    
    public int binarySearch(int[] arr , int start , int end){
        int max = arr[start] + arr[end];
        for(int index = 1; index < arr.length / 2; index ++){
            int sum = arr[index] + arr[arr.length - index - 1];
            max = Math.max(sum , max);
        }
        return max;
    }
    
    public int getLength(ListNode node){
        int length = 0;
        while(node.next != null){
            node = node.next;
            length++;
        }
        return length + 1;
    }
}