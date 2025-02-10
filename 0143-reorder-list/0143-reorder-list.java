                                        LOGIC FOR THIS CODE
                                            
1.Find the middle** using slow and fast pointers.  
2.Reverse the second half** starting from `slow.next`.  
3.Break the link** by setting `slow.next = null`.  
4.Merge both halves** by alternating nodes.  
5.Stop when `right` is null**, ensuring correct order.  
    
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
       ListNode prev=null;
        ListNode current=slow.next;
        slow.next=null;
        ListNode right_head=null;
        while(current!=null){
            ListNode x=current.next;
            current.next=prev;
            prev=current;
            current=x;
        }
        right_head=prev;

        ListNode left=head;
        ListNode right=right_head;

        while(right!=null){
            ListNode left_next=left.next;
            ListNode right_next=right.next;
            left.next=right;
            right.next=left_next;
            left=left_next;
            right=right_next;
        }
    }
}
