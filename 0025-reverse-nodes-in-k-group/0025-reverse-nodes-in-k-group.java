class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        ListNode temp_newNode=dummy;
        ListNode current=head;
        ListNode prev=null;
        ListNode newNode=null;
        ListNode end=null;
        while(current!=null){
            int first=0;
           int count=0;
           ListNode temp=current;
            while(count<k&&temp!=null){
                count++;
                temp=temp.next;
            }
            if(count==k){
                for(int i=0;i<k && current != null;i++){
                    if(first==0){
                        end=current;
                        first++;
                    }
                    newNode=current.next;
                    current.next=prev;
                    prev=current;
                    current=newNode;
                }
                temp_newNode.next=prev;
                temp_newNode=end;
                prev=null;
            }
            else{
                temp_newNode.next=current;
                break;
            }
        }
        return dummy.next;
    }
}