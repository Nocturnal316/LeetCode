class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        String lower = s.toLowerCase();
        char[] chars = lower.toCharArray();
        int left = 0;
        int right = chars.length-1;
        while(left < right){
            while(left < right && !Character.isLetterOrDigit(chars[left])) left++;
            while(left < right && !Character.isLetterOrDigit(chars[right])) right--;
            if(chars[left] != chars[right]) return false;
            left++;
            right--;
        }
        return true ;
    }
}