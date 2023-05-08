class Solution {
    public int maxArea(int[] height) {
        int lo = 0, hi = height.length -1, max = 0;
        //Area = length of shorter vertical line * distance between lines
        while(lo < hi){
            int area = (hi-lo) * Math.min(height[lo], height[hi]);
            max = Math.max(max,area);
            if(height[lo] <  height[hi]){
                lo++;
            }else{
                hi--;
            }
        }
        return max;
        
    }
}