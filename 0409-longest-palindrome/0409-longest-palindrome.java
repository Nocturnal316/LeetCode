class Solution {
    public int longestPalindrome(String s) {
        if(s.length() == 1) return 1;
        HashSet<Character> set = new HashSet<>();
        for(Character c : s.toCharArray()){
            if(set.contains(c)){
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        return set.size() <= 1 ? s.length() : s.length()  - set.size() +1;
     
        
    }
}