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
    public int pairSum(ListNode head) {
        ArrayList<Integer>list =new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        int i=0;
        int j=list.size()-1;
        int max_result=0;
        while(i<j){
            int sum=list.get(i)+list.get(j);
            if(sum>max_result){
                max_result=sum;
            }
            i++;
            j--;
        }
        return max_result;
    }
}