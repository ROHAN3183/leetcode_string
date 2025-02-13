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
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode current=head.next;
        ListNode result_head=current;
        ListNode prev =head;
        ListNode x=head;
        while(x!=null){
            x=current.next;
            if(x!=null && x.next!=null){
                current.next=prev;
                prev.next=x.next;
                prev=x;
                current=x.next;
            }
            else{
                current.next=prev;
                prev.next=x;
                break;
            }
        }
        return result_head;
    }
}