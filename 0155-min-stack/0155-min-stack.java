class MinStack {
    private Stack<Long> stack=new Stack<>();
    private long min_val; 
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push((long)val);
            min_val=val;
        }
        else{
            if(val< min_val){
                stack.push(2L*val-min_val);
                min_val=val;
            }
            else{
                stack.push((long)val);
            }
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        else{
            if(stack.peek()< min_val){
                min_val=2L*min_val-stack.peek();
            }
            stack.pop();
        }
    }
    
    public int top() {
        if((stack.peek()< min_val)){
            return (int) min_val;
        }
        else{
            return (int) (long)stack.peek();
        }
    }
    
    public int getMin() {
        return (int)min_val;
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