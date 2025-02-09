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
# Brute Code
class Solution {                                                                 // USING EXTRA MEMORY EVERY_TIME
    public ListNode partition(ListNode head, int x) { // 1) just create the dummy_less node to track the head of less element then the 'x' .
        ListNode dummy_less=new ListNode(-1);        //  2) just create the dummy_more node to track the head of greater then the 'x'.
        ListNode prev_less=dummy_less;              //   3) just create every time a newnode to store the value .
        ListNode current_less=null;                 //   4) current will point towards the newnode address whereas prev will point towards last node
        ListNode temp=head;                         //      to put the the address of cuurent in prev.next
        ListNode dummy_more=new ListNode(-1);       //   5) Same for greater than 'x' also .
        ListNode prev_more=dummy_more;
        ListNode current_more=null;
        while(temp!=null){
            if(temp.val<x){
                current_less=new ListNode(temp.val);
                prev_less.next=current_less;
                prev_less=current_less;
            }
            else{
                current_more=new ListNode(temp.val);
                prev_more.next=current_more;
                prev_more=current_more;
            }
            temp=temp.next;
        }
        prev_more.next=null;
        prev_less.next=dummy_more.next;
        return dummy_less.next;
    }
}

# Otimized Code
    
class Solution {                                                          // WITHOUT THE EXTRA_MEMORY
    public ListNode partition(ListNode head, int x) {  // 1) here just change the link with the help of the temp as in last brute code. 
        ListNode dummy_less=new ListNode(-1);
        ListNode prev_less=dummy_less;

        ListNode dummy_more=new ListNode(-1);
        ListNode prev_more=dummy_more;

        ListNode temp=head;
        while(temp!=null){
            if(temp.val<x){
                prev_less.next=temp;
                prev_less=temp;
            }
            else{
                prev_more.next=temp;
                prev_more=temp;
            }
            temp=temp.next;
        }
        prev_more.next=null;
        prev_less.next=dummy_more.next;
        return dummy_less.next;
        
    }
}

