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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp=head;
        ListNode tail=head;
        int length=0;
        while(temp!=null){
            length++;
            tail=temp;
            temp=temp.next;
        }
        if(k==0){
            return head;
        }
        if(head==null){
            return null;
        }
        k=k%length;

        tail.next=head;
        ListNode temp2=head;
        int pos=length-k;
        int result=0;
        while(result<pos-1){
            result++;
            temp2=temp2.next;
        }
        ListNode ans=temp2.next;
        temp2.next=null;
        return ans;
    }
}