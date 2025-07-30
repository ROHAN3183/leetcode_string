class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int stream = 1;
        int idx = 0;
        while(stack.size()<target.length && stream <=n){
            stack.push(stream);
            result.add("Push");
            if(stack.peek()!=target[idx]){
                stack.pop();
                result.add("Pop");
            }
            else{
                idx++;
            }
            stream++;
        }
        return result;
    }
}