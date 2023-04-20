class Solution {
     
    int size;
    int count = 0;
    ArrayList ans;
    public int totalNQueens(int n) {
        size = n;
        boolean[][] board = new boolean[n][n];
        placeQueen(board,0);
        return count;
    }
    
  
    public boolean isSafe(boolean[][] board, int row, int col) {
        //because we are places queens from top row and down
        //we only need to check upward raidous for previous queens
        // at current place we are considering.
        
        //check up 
        for(int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }
        int maxleft=Math.min(row,col);
        //check left diagnol
        for(int i=1;i<=maxleft;i++){
            if(board[row-i][col-i]){
                return false;
            }
        }
        //check right diagnal
        int maxright=Math.min(row,board.length-col-1);
        for(int i=1;i<=maxright;i++){
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }
    
    public void placeQueen(boolean[][] curBoard, int r){
        if(r == size){
            count++;
            return;
        }
        for(int col = 0; col < size; col++){
            if(isSafe(curBoard,r,col)){
                curBoard[r][col] = true;
                placeQueen(curBoard, r+1);
                curBoard[r][col] = false;
            }
        }
    }
}
