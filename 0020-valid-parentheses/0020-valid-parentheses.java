class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        
        for(Character c : s.toCharArray()){
            if(!map.containsKey(c)){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;
                
                if(stack.peek() != map.get(c)) return false;
                
                stack.pop();
            }
        }
        
        return stack.isEmpty();
        
    }
}