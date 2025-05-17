class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        Stack<Pair>openStack=new Stack<>();
        Stack<Integer>index_AstricStack=new Stack<>();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='*'){
                index_AstricStack.push(i);
            }
            else if(ch=='('){
                openStack.push(new Pair(ch,i));
            }
            else{
                if(!openStack.isEmpty() && ch==')'){
                    openStack.pop();
                }
                else if(!index_AstricStack.isEmpty() && ch==')' ){
                    index_AstricStack.pop();
                }
                else{
                    return false;
                }
            }
        }


        //remaining '('

        while(!openStack.isEmpty() && !index_AstricStack.isEmpty()){
            Pair top=openStack.pop();
            int index=index_AstricStack.pop();
            if(top.nums > index){
                return false;
            }

        }

        return openStack.isEmpty();


    }
    class Pair{
        char ch;
        int nums;
        Pair(char ch,int nums){
            this.ch=ch;
            this.nums=nums;
        }
    }
}