class Solution {
    public int romanToInt(String s) {
        int prev  = 0;
        int total = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        for(int i = s.length() -1; i >= 0; i--){
            int cur = map.get(s.charAt(i));
            if(prev <= cur){
                total += cur;
            }else{
                total -= cur;
            }
            prev = cur;
        }
        return total;
    }
}