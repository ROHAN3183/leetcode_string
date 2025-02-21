class MinStack {
    private Stack<Integer> stack=new Stack<>();
    private int min_val=0; 
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(val);
            min_val=val;
        }
        else{
            if(val< min_val){
                stack.push(2*val-min_val);
                min_val=val;
            }
            else{
                stack.push(val);
            }
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        else{
            if(stack.peek()< min_val){
                min_val=2*min_val-stack.peek();
            }
            stack.pop();
        }
    }
    
    public int top() {
        if(stack.peek()< min_val){
            return min_val;
        }
        else{
            return stack.peek();
        }
    }
    
    public int getMin() {
        return min_val;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */