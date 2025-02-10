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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer>stack=new Stack<>();
        ListNode temp=head;
        while(temp!=null){
            stack.push(temp.val);
            temp=temp.next;
        }
        temp=head;
        while(stack.size()>0){
            int x=stack.pop();
            temp.val=x;
            temp=temp.next;
        }
        stack.clear();
        temp=head;
        int maxi=0;
        while(temp!=null){
            if(temp.val>=maxi){
                maxi=Math.max(temp.val,maxi);
                stack.push(temp.val);
            }
            temp=temp.next;
        }
        ListNode dummy=head;
        ListNode prev=dummy;
       // ListNode prev_node=null;
        while(stack.size()>0){
            int x=stack.pop();
            prev.next=new ListNode(x);
           // prev_null=prev;
            prev=prev.next;
        }
       // prev_null.next=null;
        return dummy.next;
    }
}