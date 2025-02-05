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
# BRUTE FORCE
class Solution {
    public ListNode reverseList(ListNode head) { // Using extra space adding to stack then again poping back to linklist because 
        Stack<Integer>stack=new Stack<>();      // stack follow LIFO .
        ListNode temp=head;
        while(temp!=null){
            stack.push(temp.val);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            temp.val=stack.pop();
            temp=temp.next;
        }

        return head;
    }
}
# OPTIMIZED CODE
class Solution {
    public ListNode reverseList(ListNode head) {// Placing last node in current node.next
        if(head==null ||head.next==null){
            return head;
        }
        ListNode prev=null;
        ListNode temp=head;
        ListNode x=null;
        while(temp!=null){
            x=temp.next;
            temp.next=prev;
            prev=temp;
            temp=x;
        }
        return prev;
    }
}
