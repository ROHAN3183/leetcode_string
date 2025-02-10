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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
       ListNode prev=null;
        ListNode current=slow.next;
        slow.next=null;
        ListNode right_head=null;
        while(current!=null){
            ListNode x=current.next;
            current.next=prev;
            prev=current;
            current=x;
        }
        right_head=prev;

        ListNode left=head;
        ListNode right=right_head;

        while(right!=null){
            ListNode left_next=left.next;
            ListNode right_next=right.next;
            left.next=right;
            right.next=left_next;
            left=left_next;
            right=right_next;
        }
    }
}