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
# Brute Code
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int length=0;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        int delete_pos=length-n;
        if(delete_pos==0){
            return head.next;
        }
        int traverse=0;
        ListNode prev=head;
        ListNode current=head;
        while(current.next!=null && traverse<delete_pos){
            traverse++;
            prev=current;
            current=current.next;
        }
        prev.next=current.next;
        return head;
    }
}

# Optimized Code
    
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        for(int i=0;i<n;i++){
            temp=temp.next;
        }
        if(temp==null){
            return head.next;
        }
        ListNode prev=head;
        while(temp!=null &&temp.next!=null){
            prev=prev.next;
            temp=temp.next;
        }
        prev.next=prev.next.next;
        return head;
    }
}
