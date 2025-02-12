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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp=head;
        int length=0;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        temp=head;
        int left_pos=k;
        int right_pos=length-k+1;
        int pos=1;
        boolean flag1=false;
        boolean flag2=false;
        ListNode prev_left=null;
        ListNode left_node=null;
        ListNode left_next_node=null;
        ListNode prev_right=null;
        ListNode right_node=null;
        ListNode right_next_node=null;
        ListNode prev=null;

        while(temp!=null){
            if(pos==left_pos){
                prev_left=prev;//100
                left_node=temp;//200
                left_next_node=temp.next;//300
                flag1=true;
            }
            if(pos==right_pos){
                prev_right=prev;//300
                right_node=temp;//400
                right_next_node=temp.next;//500
                flag2=true;
            }
            if(flag1 && flag2){
                prev_left.next=right_node;
                right_node.next=left_next_node;
                prev_right.next=left_node;
                left_node.next=right_next_node;
                break;
            }
            prev=temp;
            temp=temp.next;
            pos++;
        }
        return head;
    }
}