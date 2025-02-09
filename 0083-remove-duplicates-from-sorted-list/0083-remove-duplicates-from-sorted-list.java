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
        ListNode current=head.next;
        ListNode prev=head;
        if(head==null || head.next==null){
            return head;
        }
        while(current!=null){
            if(current.val!=prev.val){
                prev.next=current;
                prev=current;
            }
            current=current.next;
        }
        prev.next=null;
        return head;
    }
}