                                          # LOGIC OF THIS CODE
                                            
1) Take a LinkedHashSetto store the the values of the element.
2) Again traverse to the set to put the back element to the linkist using the temp as pointer
   and prev .
3) In last put the prev next=null;    

#BRUTE CODE
    
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        Set<Integer>set=new LinkedHashSet<>();
        ListNode temp=head;
        while(temp!=null){
            set.add(temp.val);
            temp=temp.next;
        }
        temp=head;
        ListNode prev=null;
      for(int i:set){
        temp.val=i;
        prev=temp;
        temp=temp.next;
      }
      prev.next=null;
      return head;
    }
}
                                                # OTIMIZED CODE LOGIC
1) Take two pointer current and the prev.
2) current=head.next where as prev=head so that current will be always at least one ahead .
3) If current.val!=prev.val then prev.next=curent and alway more current=current.next;
4) In last the prev.next=null.
5) Return head. 
                                                   
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head==null || head.next==null){
            return head;
        }
        ListNode current=head.next;
        ListNode prev=head;
        while(current!=null){
            if(current.val!=prev.val){
                prev.next=current;
                prev=current;
            }
            current=current.next;
        }
        prev.next=null;
        return head;
    }
}
