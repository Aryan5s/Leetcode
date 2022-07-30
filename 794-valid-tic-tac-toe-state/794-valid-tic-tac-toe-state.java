class Solution {
    public boolean checkForEnd(char[][] board, Character c) {
        for(int i=0;i<3;i++){
            //row
            if(board[i][0]==board[i][1] && board[i][1]==board[i][2] && board[i][0]==c){
                return true;
            }
            //column
            if(board[0][i]==board[1][i] && board[1][i]==board[2][i] && board[0][i]==c){
                return true;
            }
        }
        // diagonal 1
        if(board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[0][0]==c){
            return true;
        }
        // diagonal 2
        if(board[0][2]==board[1][1] && board[1][1]==board[2][0] && board[0][2]==c){
            return true;
        }
        
        return false;
    }
    public boolean validTicTacToe(String[] board) {
        
        int x = 0;
        int o = 0;
        char[][] board1 = new char[3][3];
        int j = 0;
        // check if count of x == o or x == o + 1 
        for(String row:board){
            for(int i=0;i<3;i++){
                board1[j][i] = row.charAt(i);
                if(row.charAt(i)=='X'){
                    x++;
                }else if(row.charAt(i)=='O'){
                    o++;
                }
            }
            j++;
        }
        if(x!=o && x!=o+1) {
            return false;
        }
        
        // check for 3 x and 3 o
        // if 3 x is there, count of o==x-1
        // if 3 o is there, count of x == o
        if(this.checkForEnd(board1,'X') && o!=x-1){
            return false;
        }
        if(this.checkForEnd(board1,'O') && o!=x){
            return false;
        }
       
        return true;
    }
}