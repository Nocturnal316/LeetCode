class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] dict = new int[26];
        
        for(char a : s.toCharArray()){
            dict[a-'a']++;
        }
        
        for(char a : t.toCharArray()){
            if(--dict[a -'a'] < 0) return false;
        }
        
        return  true;
    }
}