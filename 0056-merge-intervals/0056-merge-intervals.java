class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        if(intervals.length == 1) return intervals;
        
        
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        
        int[] curInterval = intervals[0];
        
        for(int i = 1; i < intervals.length;i++ ){
            int[] interval = intervals[i];
            System.out.println(interval[0] +", "+ interval[1]);
            
            if(curInterval[1] < interval[0]){
                ans.add(curInterval);
                curInterval = interval;
            }else if(interval[1] < curInterval[0] ){
                ans.add(interval);
            }else{
                curInterval[0] = Math.min(curInterval[0],interval[0]);
                curInterval[1] = Math.max(curInterval[1],interval[1]);
            }
        }
        
        ans.add(curInterval);
        
        return ans.toArray(new int[ans.size()][]);
    }
}