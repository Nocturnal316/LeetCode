class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList();
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        int m = mat.length;
        int n = mat[0].length;
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n;col++){
                if(mat[row][col] == 0){
                    queue.add(new int[]{row,col});
                }else{
                    mat[row][col] = Integer.MAX_VALUE;
                }
            }
        }
        
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            for(int[] direct : dir){
                int newR = row +direct[0];
                int newC = col +direct[1];
                
                if(newR < 0 || newR >= m || newC < 0 
                   || newC >= n || mat[newR][newC] <= mat[row][col]+1) continue;
                
                queue.add(new int[]{newR,newC});
                mat[newR][newC] = mat[row][col] + 1;
            }
        }
        return mat;
    }
}