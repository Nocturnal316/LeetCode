class Solution {
    
    public void solveSudoku(char[][] board) {
        for(int i = 0; i < 9;i++){
            for(int j = 0; j < 9; j++){
                 solveBackTrack(board,i,j);
            }
        }
     
    }
    
     public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        
        for(int row = 0; row < m; row++){
            HashSet<Character> seen = new HashSet<>();
            for(int col = 0; col < m; col++){
                char c = board[row][col];
                if(!Character.isDigit(c)) continue;
                if( seen.contains(c)) return false;
                seen.add(c);
            }
        }
        
        for(int row = 0; row < m; row++){
            HashSet<Character> seen = new HashSet<>();
            for(int col = 0; col < m; col++){
                char c = board[col][row];
                if(!Character.isDigit(c)) continue;
                if( seen.contains(c)) return false;
                seen.add(c);
            }
        }
        
       for (int box = 0; box < m; box++){
             HashSet<Character> seen = new HashSet<>();
            for (int row = 0; row < 3; row++){
                for (int col = 0; col < 3; col++){
                    char c = board[row + 3 * (box / 3)][col + 3 * (box % 3)];
                    if(!Character.isDigit(c)) continue;
                    if( seen.contains(c)) return false;
                    seen.add(c);
                }
            }
        }
        
        return true;
    }
    
    public boolean solveBackTrack(char[][] board,int r, int c){
        if(c == 9) return solveBackTrack(board,r+1,0);
        if(r == 9) return true;
        if(Character.getNumericValue(board[r][c]) != -1){
            //System.out.println(Character.getNumericValue(board[r][c]));
            return solveBackTrack(board,r,c+1);
        }
           
        if(board[r][c] == '.'){
            for(int i = 1; i <= 9;i++){
                board[r][c] =  (char)(i+ '0');
                if(isValidSudoku(board) && solveBackTrack(board,r,c+1)) return true;
            }
            board[r][c] = '.';
        }
        return false;
    }
}