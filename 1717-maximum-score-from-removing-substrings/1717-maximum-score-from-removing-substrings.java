class Solution {
    public int maximumGain(String s, int x, int y) {


        if(x>y){
            int value1=scoreCalculator(s,'a','b',x,'b','a',y);
            return value1;
        }
        else if(x<y){
            int value2=scoreCalculator(s,'b','a',y,'a','b',x);
            return value2;
        }
        return -1;
    }
    private int scoreCalculator(String s,char first1,char second1,int val1,char second2,char first2,int val2 ){
        int n=s.length();
        Stack<Character>stack=new Stack<>();
        int score=0;

        for(int i=0;i<n;i++){//"ba removal"

            char ch=s.charAt(i);

            if(!stack.isEmpty() && stack.peek()==first1 && ch==second1){
                stack.pop();
                score=score+val1;
            }
            else{
                stack.push(ch);
            }

        }
        StringBuilder str=new StringBuilder();

        while(!stack.isEmpty()){
            char ch=stack.pop();
            str.append(ch);

        }
        String result=str.reverse().toString();
        Stack<Character>newstack=new Stack<>();

        for(int i=0;i<result.length();i++){//"ab removal"

            char ch=result.charAt(i);

            if(!newstack.isEmpty() && newstack.peek()==second2 && ch==first2){
                newstack.pop();
                score=score+val2;
            }
            else{
                newstack.push(ch);
            }

        }

        return score;
    }
}