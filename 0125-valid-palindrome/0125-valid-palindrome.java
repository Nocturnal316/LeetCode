class Solution {
    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase();
        char[] chars = lower.toCharArray();
        if(lower.length() == 1) return true;
        int left = 0;
        int right = chars.length-1;
        while(left < right){
            while(left < right && !Character.isLetterOrDigit(chars[left])) left++;
            while(left < right && !Character.isLetterOrDigit(chars[right])) right--;
            if(left > right || chars[left] != chars[right]) return false;
            left++;
            right--;
        }
        
        return true ;
    }
}