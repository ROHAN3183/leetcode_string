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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp2=list2;
        ListNode prev=null;
        while(temp2!=null){
            prev=temp2;
            temp2=temp2.next;
        }
        int pos=0;
        ListNode temp1=list1;
        ListNode prev_left=null;
        while(pos<=b){
            if(pos==a){
                prev_left.next=list2;
            }
            if(pos==b){
                prev.next=temp1.next;
            }
            pos++;
            prev_left=temp1;
            temp1=temp1.next;
        }
        return list1;
    }
}