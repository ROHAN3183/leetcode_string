                                Logic of code using space (2n) //for this follow apna college
1) In this take a stack which will store two pair first will be the val whereas the second will store the value of the minimum 
    as so far seen in the stack .
2) if coming value in the stack is smaller then the peek of the top of the second then now put the new value in the first part 
    and in the second part will be the min of new comming value vs already peek second value.
    
#1 class MinStack {
    private Stack<int[]> stack=new Stack<>();
    public MinStack() {
        stack=new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new int[]{val,val});
        }
        else{
            stack.push(new int[]{val,Math.min(val,stack.peek()[1])});
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        else{
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}
                                        Logic of this code using space(1)
Alway remember this formula that is (val'=2*val-min_val) this will come under the use whenever the comming val is smaller then the
min_val.otherwise just push into the stack .while during the poping out the stack.peek() if stack.peek()<min_val then we need to 
chnge the min_val also because it will get deleted for that formula is (min_val=2*min_val-stack.peek).

#2 class MinStack {
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
