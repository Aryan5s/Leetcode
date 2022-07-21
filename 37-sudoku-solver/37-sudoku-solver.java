class Solution {
    public void solveSudoku(char[][] board) {
        solveSudokuBoard(board);
    }
    
    public boolean solveSudokuBoard(char[][] board)
    {        
        int size = 9;
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                if(board[i][j] == '.')
                {
                    for(int value = 1; value <=9; value++)
                    {
                        board[i][j] = (char)(value + (int)'0');
                        if(this.isValid(board, i, j))
                        {
                            if(solveSudokuBoard(board))
                                return true;
                        }
                        
                        board[i][j] = '.';
                    }
                    
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isValid(char[][] board, int row, int col)
    {
        int size = 9;
        boolean numbers[] = new boolean[size+1];
        
        // Check the column
        for(int i = 0; i < size; i++) {
            if(board[i][col] != '.') {
                if(numbers[board[i][col] - '0']) {
                    return false;
                }
                
                numbers[board[i][col] - '0'] = true;
            }
        }
        
        // Check the row
        numbers = new boolean[size+1];
        for(int i = 0; i < size; i++) {
            if(board[row][i] != '.') {
                if(numbers[board[row][i] - '0']) {
                    return false;
                }
                
                numbers[board[row][i] - '0'] = true;
            }
        }
        
        // Checking the grid.
        numbers = new boolean[size+1];
        row = (row/3) * 3;
        col = (col/3) *3;
        
        for(int i = row; i < row +3; i++) {
            for(int j = col; j < col +3 ; j++) {
                if(board[i][j]!= '.') {
                    if(numbers[board[i][j] - '0']) {
                        return false;
                    }
                    
                    numbers[board[i][j] - '0'] = true;
                }
            }
        }
        
        return true;
    }
}