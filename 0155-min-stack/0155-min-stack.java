class MinStack {

    Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
             stack.push(val);
             stack.push(val);
        }else{
            int topMin = Math.min(stack.peek(),val);
            stack.push(val);
            stack.push(topMin);
        } 
    }
    
    public void pop() {
        stack.pop();
        stack.pop();
    }
    
    public int top() {
        int min = stack.pop();
        int top = stack.pop();
        
        stack.push(top);
        stack.push(min);
        
        return top;
    }
    
    public int getMin() {
        return stack.peek();
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