class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 2) return true;
        long lo = 1;
        long hi = num;
        while(lo <= hi){
            long mid = lo + (hi -lo) /2;
            long sqrt = mid * mid;
            if(sqrt == num){
                return true;
            }
            else if(sqrt > num ){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return false;
    }
}