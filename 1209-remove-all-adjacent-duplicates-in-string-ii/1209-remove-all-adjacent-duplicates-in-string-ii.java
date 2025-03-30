class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        StringBuilder final_result = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            stack.push(ch);
            manipulation(stack, k);
        }

        while(!stack.isEmpty()){
            final_result.append(stack.pop());
        }
        return final_result.reverse().toString();
    }

    private void manipulation(Stack<Character> stack, int k){
        if(stack.size() < k) return;

        boolean flag = true;
        StringBuilder str = new StringBuilder();
        int count = 0;

        while(!stack.isEmpty() && count < k){
            str.append(stack.pop());
            count++;
        }

        char[] result = str.toString().toCharArray();

        for(int j = 1; j < result.length; j++){
            if(result[j] != result[j - 1]){
                flag = false;
                break;
            }
        }

        if(!flag){
            for(int m = result.length - 1; m >= 0; m--){
                stack.push(result[m]);
            }
        }
    }        
}
