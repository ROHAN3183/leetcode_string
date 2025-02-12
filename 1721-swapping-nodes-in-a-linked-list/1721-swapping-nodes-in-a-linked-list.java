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
        boolean flag1=false;
        boolean flag2=false;
        ListNode left_node=null;
        ListNode right_node=null;
        int left_val=0;
        int right_val=0;
        int count=1;
        for(int i=1;i<=length;i++){
            if(count==left_pos){
                left_val=temp.val;
                left_node=temp;
                flag1=true;
            }
            if(i==right_pos){
                right_val=temp.val;
                right_node=temp;
                flag2=true;
            }
            if(flag1 &&flag2){
                left_node.val=right_val;
                right_node.val=left_val;
            }
            count++;
            temp=temp.next;
        }
        return head;
    }
}