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