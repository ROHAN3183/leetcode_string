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
    public ListNode rotateRight(ListNode head, int k) { //calculate the length of linklist and also maintain tail for last node
        ListNode temp=head;                            //add the tail.next =head.
        ListNode tail=head;                            // get the length where need to put null using subtracting length of lini
        int length=0;                                  //with the position to be change
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
