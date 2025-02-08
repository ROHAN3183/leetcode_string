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
#BRUTE CODE
    
class Solution {
    public boolean isPalindrome(ListNode head) { // 1) Just add all the element in stack . 
        ListNode temp=head;                      // 2) while poping out the element just compare the element with linklist element 
        Stack<Integer> stack=new Stack<>();      // 3) while poping the element it don't match with the linkist then return false.
        while(temp!=null){
            stack.push(temp.val);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null&&!stack.isEmpty()){
            int reversed_character=stack.pop();
            if(reversed_character!=temp.val){
                return false;
            }
            temp=temp.next;
        }
        return true;
    }
}

#OPTIMIZED CODE
    
class Solution {
    public boolean isPalindrome(ListNode head) { // 1) find the mid element using slow fast Approach.
        if(head==null ||head.next==null){        // 2) Reverse the linklist from slow to last of linklist.
            return true;                         // 3) Then again traverse from fist_part of head and second_part head until the any part don't become the null. 
        }
        ListNode temp=head;
        ListNode fast=head;
        ListNode slow=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            //prev=slow;
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        prev.next=null;
        prev=reversed(slow);
        while(temp!=null && prev!=null){
            if(temp.val!=prev.val){
                return false;
            }
            temp=temp.next;
            prev=prev.next;
        }
        return true;
    }
    private ListNode reversed(ListNode slow){
        ListNode current=slow;
        ListNode prev=null;
        while(current!=null){
            ListNode nextnode=current.next;
            current.next=prev;
            prev=current;
            current=nextnode;
        }
        return prev;
    }
}

