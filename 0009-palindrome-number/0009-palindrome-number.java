class Solution {
public boolean isPalindrome(int x) {
        if(x < 0)   return false;
        if(x < 10)  return true;
        
        Long  rev = 0L;
        int original = x;
        
        while(x!=0) {
            long rem = x % 10;
            rev = rev*10 + rem;
            x = x/10;
        }
        
        return (rev == original);
    }
}