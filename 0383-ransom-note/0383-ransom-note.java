class Solution {
    //O(magazine)
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] magazineInventory = new int[26];
        for(Character c : magazine.toCharArray()){
            magazineInventory[c-'a']++;
        }
        
        for(Character c : ransomNote.toCharArray()){
            if(--magazineInventory[c-'a'] < 0) return false;
        }
        return true;
    }
}