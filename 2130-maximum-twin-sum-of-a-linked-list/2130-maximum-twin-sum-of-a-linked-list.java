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
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null&&fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next;
        }
        prev.next=null;


        ListNode current=slow;
        prev=null;
        while(current!=null){
            ListNode next_node=current.next;
            current.next=prev;
            prev=current;
            current=next_node;
        }
        slow.next=null;
        ListNode temp1=head;
        ListNode temp2=prev;
        int max_result=0;
        while(temp1!=null&&temp2!=null){
            int sum=temp1.val+temp2.val;
            max_result=Math.max(sum,max_result);
            temp1=temp1.next;
            temp2=temp2.next;
        }
    return max_result;
    }
}