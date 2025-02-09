                                                LOGIC FOR THIS
 1) Take a map to store the value and node .
 2) If map not contain the node and value then put it into the map.
 3) If map contain the node return the temp2.
 4) Else return the null. 

#1 Brute force
    
    public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer> map=new HashMap<>();
        ListNode temp1=headA;
        ListNode temp2=headB;
        while(temp1!=null){
            if(!map.containsKey(temp1)){
                map.put(temp1,temp1.val);
            }
            temp1=temp1.next;
        }
        while(temp2!=null){
            if(!map.containsKey(temp2)){
                map.put(temp2,temp2.val);
            }
            else{
                return temp2;
            }
            temp2=temp2.next;
        }
        return null;
    }
}
                                            LOGIC FOR THIS
1) Calculate the length of the head1 linklist.
2) Calculate the length of the head2 linklist.
3) Find the difference between the first linklist length and the second linklist length.
4) whoever is larger try to make to reach the smallerone by using loop.
5) If if both temp1 and temp2 found it mean intesection has been found.
                                                
#2 Optimized Code

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1=headA;
        ListNode temp2=headB;
        int length1=0;
        int length2=0;
        while(temp1!=null){
            length1++;
            temp1=temp1.next;
        }
        while(temp2!=null){
            length2++;
            temp2=temp2.next;
        }

        temp1=headA;
        temp2=headB;
        
        int n=Math.abs(length1-length2);
        if(length1>length2){
            for(int i=0;i<n;i++){
                temp1=temp1.next;
            }
        }
        else{
            for(int i=0;i<n;i++){
                temp2=temp2.next;
            }
        }

        while(temp1!=null && temp2!=null){
            if(temp1==temp2){
                return temp2;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return null;
    }
}
