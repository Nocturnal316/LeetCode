class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        
        for(int row = 0; row < m; row++){
            HashSet<Character> seen = new HashSet<>();
            for(int col = 0; col < m; col++){
                if(!Character.isDigit(board[row][col])) continue;
                if( seen.contains(board[row][col])) return false;
                seen.add(board[row][col]);
            }
        }
        
        for(int row = 0; row < m; row++){
            HashSet<Character> seen = new HashSet<>();
            for(int col = 0; col < m; col++){
                if(!Character.isDigit(board[col][row])) continue;
                if( seen.contains(board[col][row])) return false;
                seen.add(board[col][row]);
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
}