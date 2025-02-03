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
#BRUTE CODE
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode temp=head;
        ListNode traverse=head;
        int count =0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int result=0;
        while(result<count/2){
            result++;
            traverse=traverse.next;
        }
        head=traverse;
        return head;
    }
}
# OPTIMIZED CODE 
class Solution {
    public ListNode middleNode(ListNode head) { // slow and fast approach
        ListNode slow=head;
        ListNode fast =head;
        while(fast!=null && fast.next!=null){
            slow =slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
