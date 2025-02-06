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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) { // first add carry to sum  
        ListNode dummy=new ListNode(0);                       // then use % will give the real sum to place in newnode where as / is used for 
        ListNode current=dummy;                               //getting carry to add for next time
        int carry=0;
        int sum=0;
        while(l1!=null ||l2!=null||carry>0){
            sum=carry;
            if(l1!=null){
                sum=sum+l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum=sum+l2.val;
                l2=l2.next;
            }
         current.next=new ListNode(sum%10);
         current=current.next;
         carry=sum/10;
          
        }
        return dummy.next;
    }
}
