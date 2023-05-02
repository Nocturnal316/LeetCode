class Solution {
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    int m;
    int n;
    public int numIslands(char[][] grid) {
    
         m = grid.length;
         n = grid[0].length;
        int count = 0;
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == '1'){
                    dfs(grid,row,col);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int row, int col){
        grid[row][col] = 2;
        
        for(int[] dir : dirs){
            int newR = row + dir[0];
            int newC = col + dir[1];
            if(newR < 0 || newR >= m || newC < 0 
               || newC >= n || grid[newR][newC] != '1') continue;
            dfs(grid,newR,newC);
        }
    }
}