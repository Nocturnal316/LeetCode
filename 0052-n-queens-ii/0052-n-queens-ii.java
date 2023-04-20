class Solution {
     
    int size;
    int count = 0;
    ArrayList ans;
    public int totalNQueens(int n) {
        size = n;
        boolean[][] board = new boolean[n][n];
        ans = new ArrayList<>();
        placeQueen(board,0);
        return ans.size();
    }
    
  
    public boolean isSafe(boolean[][] board, int row, int col) {
      
        //reason for not checking on right side of queen as we are not able to reaches 
        //there beacuse we are moving backward whatever queen attack will be there it will be on left side
        
        //on upper diagonal bothe col and row will decrease 
        // upward diagonal on left side 
        for(int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }
        int maxleft=Math.min(row,col);
        for(int i=1;i<=maxleft;i++){
            if(board[row-i][col-i]){
                return false;
            }
        }
        //lower diagonal which is on left side
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
            printBoard(curBoard);
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
    
    public void printBoard(boolean[][] board){
        StringBuilder sb = new StringBuilder();
        ArrayList temp = new ArrayList<>();
        for(int i= 0; i < size; i++){
            sb = new StringBuilder();
            for(int j = 0; j < size;j++){
                if(board[i][j] == false){
                    sb.append(".");
                }else{
                    sb.append("Q");
                }
            }
            temp.add(sb.toString());
        }
        //System.out.println(temp);
        ans.add(temp);
    }
}
