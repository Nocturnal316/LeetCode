class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        if(s.length() <= 1) return s.length();
   
        int left = 0;
        int right = 0;
        int max = 0;
        int count = 0;
        
        while(right < s.length()){
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar,0) + 1);
            
            while(map.get(rightChar) > 1){
                char leftChar = s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);
                left++;
            }
            
            count = right - left + 1;
           
            max = Math.max(count, max);
            right++;
        }
        
        return max;
        
    }
}