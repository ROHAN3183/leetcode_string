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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy_less=new ListNode(-1);
        ListNode prev_less=dummy_less;
        ListNode current_less=null;
        ListNode temp=head;

        ListNode dummy_more=new ListNode(-1);
        ListNode prev_more=dummy_more;
        ListNode current_more=null;
        while(temp!=null){
            if(temp.val<x){
                current_less=new ListNode(temp.val);
                prev_less.next=current_less;
                prev_less=current_less;
            }
            else{
                current_more=new ListNode(temp.val);
                prev_more.next=current_more;
                prev_more=current_more;
            }
            temp=temp.next;
        }
        prev_more.next=null;
        prev_less.next=dummy_more.next;
        return dummy_less.next;
    }
}

