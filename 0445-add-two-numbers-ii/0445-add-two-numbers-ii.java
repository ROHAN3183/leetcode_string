
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ListNode_reversed1=reverseList(l1);
        ListNode ListNode_reversed2=reverseList(l2);
        int carry=0;
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        int sum=0;
        while(ListNode_reversed1!=null || ListNode_reversed2!=null||carry>0){
            sum=carry;
            if(ListNode_reversed1!=null){
                sum=sum+ListNode_reversed1.val;
                ListNode_reversed1=ListNode_reversed1.next;
            }
            if(ListNode_reversed2!=null){
                sum=sum+ListNode_reversed2.val;
                ListNode_reversed2=ListNode_reversed2.next;
            }
            prev.next=new ListNode(sum%10);
            prev=prev.next;
            carry=sum/10;
        }
        ListNode result=reverseList(dummy.next);
        return result;
        
    }
      private ListNode reverseList(ListNode head) { 
        ListNode current=head;
        ListNode prev=null;
        while(current!=null){
            ListNode next_node=current.next;
            current.next=prev;
            prev=current;
            current=next_node;
        }
        return prev;
    }
}
