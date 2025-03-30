logic of the code: -'ba' is problem in the string .
1) just take two array so that we can compute the prefix_sum in first array take the no.of count of B's from leftside.
2) in second array compute the count of the A's from the last index.
3) so take the sum of the both the array of the index and the minimum will be the result that has to be deleted.
    
class Solution {
    public int minimumDeletions(String s) {

        int n=s.length();

        int [] left_count_B=new int[n];
        int [] right_count_A= new int[n];

        int count_B=0;
        int count_A=0;

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            left_count_B[i]=count_B;

            if(ch=='b'){
                count_B++;
            }
        }
        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            right_count_A[i]=count_A;

            if(ch=='a'){
                count_A++;
            }    
        }

        int deleted=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            deleted=Math.min(deleted,left_count_B[i]+right_count_A[i]);
        }

    return deleted;

    }
}

logic of the code: -'ba' is problem in the code
1) just increase the count of the deleted element whenever on the top of the stack is 'b' and comming element is 'a' then pop
    out the top of the stack also.
    
class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> stack=new Stack();
        int delete=0;
        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);
            if(stack.isEmpty()){
                stack.push(ch);
            }
            else if(stack.peek()=='b' && ch=='a'){
                stack.pop();
                delete++;
            }
            else{
                stack.push(ch);
            }
        }
        return delete;
    }
}























