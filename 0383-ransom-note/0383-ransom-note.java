class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] magazineInventory = new int[26];
        
        for(Character c : magazine.toCharArray()){
            magazineInventory[c-'a']++;
        }
        
        
        for(Character c : ransomNote.toCharArray()){
            if(magazineInventory[c-'a'] - 1 < 0) return false;
            magazineInventory[c-'a']--;
        }
        
        return true;
    }
}