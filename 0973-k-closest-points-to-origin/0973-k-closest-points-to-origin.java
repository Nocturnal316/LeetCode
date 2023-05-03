class Solution {
     class Point{
        int x;
        int y;
        int dist;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public int getDist(){
            return ((0-x)*(0-x) + (0-y)*(0-y));
        }
        
        public int[] getList(){
            return new int[]{this.x,this.y};
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> que = new PriorityQueue<>((a,b)->a.getDist() - b.getDist());
        
        for(int[] point : points){
            que.add(new Point(point[0],point[1]));
        }
        ArrayList<int[]> ans = new ArrayList<>();
        for(int i  = 0; i < k;i++){
            Point p = que.poll();
            ans.add(new int[]{p.x,p.y});
        }
        return ans.toArray(new int[ans.size()][]);
    }
}