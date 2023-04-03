class Solution {
    public double myPow(double x, int n) {
        long nAsLong = n;
        return myPowLong(x,nAsLong);
    }

    public double myPowLong(double x, long n){
        //base case
        if(n == 0) return 1.0;
        //Negative
        if(n < 0){
            x = 1/x;
            n = n*-1;
        }
        //odd/even
        double halfPower = myPowLong(x,n/2);
        if(n%2 == 0){
            return halfPower * halfPower;
        } else {
            return halfPower * halfPower * x;
        }
    }   
}