class Solution {
    public boolean isPalindrome(String s) {
        
        String temp = s.toLowerCase().replaceAll(" ","");
        char[] chart = temp.toCharArray();
        int left = 0;
        int right = chart.length-1;
        
        while(left < right){
            while( left  < right && !Character.isLetterOrDigit(chart[left])) left++;
            while( left < right  && !Character.isLetterOrDigit(chart[right])) right--;
            if( left > right  || chart[left] != chart[right]) return false;
            left++;
            right--;
        }
            
        return true;
    }
}