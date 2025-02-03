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
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        if(count==1){
            return null;
        }
        ListNode traverse=head;
        ListNode prev=head;
        int result=0;
        while(traverse.next!=null && result<count/2){
            result++;
            prev=traverse;
            traverse=traverse.next;
        }
        prev.next=traverse.next;
        return head;
    }
}