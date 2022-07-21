class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
		if(n < 1) return res;
		//record table to track queens column position at each row
        //record[r] = c
        int[] record = new int[n];
		char[][] board = new char[n][n];
        
		//build empty board
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j] = '.';
			}
		}
        
		nqueens(record, 0, n, board);
        
        return res;
    }
    
    public void nqueens(int[] record, int i, int n, char[][] board){
        //reached end of the board, find a solution
        if(i == n) {
			res.add(createBoard(board));
			return;
		}
        for(int j = 0;j<n;j++) {
			if(isValid(record, i, j)) {
				record[i] = j;
				board[i][j] = 'Q';
				nqueens(record, i+1, n,board);
				record[i] = 0;
				board[i][j] = '.';
			}
		}
        
    }
    
    public boolean isValid(int[] record, int i, int j) {
        //check previous i-1 rows and diagonal
        //here we calulate both queens slop to get rid of 3 hashtables
        //ex: previous queen at i,j, current position at i',j'
        //if their slop is 45 degree or 135 meaning that i',j' invalid
        // |i-i'| / |j-j'| = 1 is invalid ----> |j - j'| == |i-i'|
		for(int k = 0; k < i; k++) {
			if(j == record[k] || Math.abs(record[k] - j) == Math.abs(i-k)){
				return false;
			}
		}
		return true;
	}
    
    public List<String> createBoard(char[][] board) {
		List<String> ret = new ArrayList<>();
		for(int r=0;r<board.length;r++) {
			String curr_row = new String(board[r]);
			ret.add(curr_row);
		}
		return ret;
	}
}