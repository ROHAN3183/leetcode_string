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
    public boolean isPalindrome(ListNode head) {
        ListNode temp=head;
        ListNode fast=head;
        ListNode slow=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        prev=reversed(slow);
        while(temp!=null && prev!=null){
            if(temp.val!=prev.val){
                return false;
            }
            temp=temp.next;
            prev=prev.next;
        }
        return true;
    }
    private ListNode reversed(ListNode slow){
        ListNode current=slow;
        ListNode prev=null;
        while(current!=null){
            ListNode nextnode=current.next;
            current.next=prev;
            prev=current;
            current=nextnode;
        }
        return prev;
    }
}

