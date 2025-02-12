/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node>map=new HashMap<>();
        Node current=head;
        Node dummy=new Node(-1);
        Node prev=dummy;
        Node newnode=null;
        while(current!=null){
            newnode= new Node(current.val);
            prev.next=newnode;
            map.put(current,newnode);
            prev=prev.next;
            current=current.next;
        }
        Node temp_original=head;
        Node temp_copy=dummy.next;
        while(temp_original!=null){
            if(map.containsKey(temp_original.random)){
                temp_copy.random=map.get(temp_original.random);
            }
            else{
                temp_copy.random=null;
            }
            temp_original=temp_original.next;
            temp_copy=temp_copy.next;
        }
        return dummy.next;
    }
}