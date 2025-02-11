                                        LOGIC OF THIS CODE
                                            
1.Find the last node of list2** by traversing it.  
2.Find the (a-1)th node in list1** (prev_left) and the bth node.  
3.Link prev_left to list2** to merge the left part.  
4.Link list2's last node to b+1th node** to merge the right part.  
5.Return list1** as the final merged list.  

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp2=list2;
        ListNode prev=null;
        while(temp2!=null){
            prev=temp2;
            temp2=temp2.next;
        }
        int pos=0;
        ListNode temp1=list1;
        ListNode prev_left=null;
        while(pos<=b){
            if(pos==a){
                prev_left.next=list2;
            }
            if(pos==b){
                prev.next=temp1.next;
            }
            pos++;
            prev_left=temp1;
            temp1=temp1.next;
        }
        return list1;
    }
}
