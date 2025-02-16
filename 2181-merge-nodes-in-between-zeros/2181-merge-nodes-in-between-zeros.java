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
    public ListNode mergeNodes(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode current=head.next;
        ListNode prev=head;
        while(current!=null){
            if(current.val==0 && current.next==null){
                prev.next=null;
                break;
            }
            if(current.val!=0){
                prev.val=prev.val+current.val;
            }
            else{
                prev.next=current;
                prev=prev.next;
            }
            current=current.next;
        }
        return head;
    }
}