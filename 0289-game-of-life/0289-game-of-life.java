class Solution {
    public int[][] dirs = {
        {0,1},{1,0},{-1,0},{0,-1},{-1,-1},{1,1},{1,-1},{-1,1}
    };
    
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] copy = new int[m][n];
        
        
        for(int row =  0; row < m; row++){
            for(int col = 0; col < n;col++){
                copy[row][col] = board[row][col];
            }
        }
        
        for(int row =  0; row < m; row++){
            for(int col = 0; col < n;col++){
                if(board[row][col] == 1){
                    helperAlive(board, copy, row, col);
                }else{
                     helperDead(board, copy, row, col);
                }
            }
        }
        
    }
    
    public void helperAlive(int[][] board, int[][] copy, int r, int c){
        int countAlive = 0;
        for(int[] dir : dirs){
            int neighborRow = r + dir[0];
            int neighborCol = c + dir[1];
            if(neighborRow < 0 || neighborRow >= board.length 
               || neighborCol < 0 || neighborCol >= board[0].length || copy[neighborRow][neighborCol] == 0) continue;
            countAlive+=1;
        }
        
         if(countAlive == 2 || countAlive == 3){
            board[r][c] = 1;
        }else{
            board[r][c] = 0;
        }
    }
    
       public void helperDead(int[][] board, int[][] copy, int r, int c){
        int countAlive = 0;
        for(int[] dir : dirs){
            int neighborRow = r + dir[0];
            int neighborCol = c + dir[1];
            if(neighborRow < 0 || neighborRow >= board.length 
               || neighborCol < 0 || neighborCol >= board[0].length || copy[neighborRow][neighborCol] == 0) continue;
            countAlive+=1;
        }
        
        if(countAlive == 3){
            board[r][c] = 1;
        }
    }
}