class Solution {
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int numOranges = 0;
        int level = 0;
        HashSet<int[]> seen = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //becareful of logic
                //at first i counted all oranges and check
                // to see if fresh == rotten.
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
                
                if(grid[i][j] == 1){
                    numOranges+=1;
                }
            }
        }
        
        //base case if there are no fresh oranges 
        if (numOranges == 0) {
            return 0;
        }

        while(!queue.isEmpty()){
            //level = minute 
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[]  pos = queue.poll();
                int curR = pos[0];
                int curC = pos[1];
                for(int[] dir: dirs){
                    int newR = curR +dir[0];
                    int newC = curC +dir[1];
                    if(newR < 0 || newR >= m || newC < 0 || newC >= n 
                       || grid[newR][newC] == 0 || grid[newR][newC] == 2 ) continue;
                    queue.offer(new int[]{newR,newC});
                    grid[newR][newC] = 2;
                    numOranges-=1;
                }
            }
            level++;
        }
        //last orange may have caused level increase to substract by 1
        return numOranges == 0 ? level-1 : -1;
    }
}