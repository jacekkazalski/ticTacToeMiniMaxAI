package tictactoe;

public class HardAI extends Player{
    String ai;
    String opponent;

    @Override
    protected void makeAMove(String[][] board, String move) {
        this.ai = move;
        this.opponent = "O";
        String [][] modifiedBoard = copyBoard(board);
        if(ai.equals("O")){
            this.opponent = "X";
        }
        int bestMove = -10000;
        for (int i = 0; i< 3; i++){
            for(int j = 0; j< 3;j++){
               if(board[i][j] .equals("_")) {
                   modifiedBoard[i][j] = ai;
                   int moveValue = minMax(modifiedBoard, opponent,0);
                   modifiedBoard[i][j] = "_";
                   if (moveValue > bestMove) {
                       bestMove =moveValue;
                       cordX = i;
                       cordY = j;
                   }
               }
            }
        }
        System.out.println("Making a move level \"hard\"");
        board[cordX][cordY] = move;


    }
    private int win(String[][] modifiedBoard) {
        for (int i = 0; i < modifiedBoard.length; i++) {

            if (modifiedBoard[i][0].equals(modifiedBoard[i][1]) && modifiedBoard[i][0].equals(modifiedBoard[i][2]) && !modifiedBoard[i][0].equals("_")) {
                if(modifiedBoard[i][0].equals(ai)){
                    return 10;
                }
                else{
                    return  -10;
                }
            } else if (modifiedBoard[0][i].equals(modifiedBoard[1][i]) && modifiedBoard[0][i].equals(modifiedBoard[2][i]) && !modifiedBoard[0][i].equals("_")) {
                if(modifiedBoard[0][i].equals(ai)){
                    return 10;
                }
                else{
                    return  -10;
                }
            }
        }
        if (modifiedBoard[0][0].equals(modifiedBoard[1][1]) && modifiedBoard[1][1].equals(modifiedBoard[2][2]) && !modifiedBoard[0][0].equals("_")) {
            if(modifiedBoard[0][0].equals(ai)){
                return 10;
            }
            else{
                return  -10;
            }
        } else if (modifiedBoard[2][0].equals(modifiedBoard[1][1]) && modifiedBoard[2][0].equals(modifiedBoard[0][2]) && !modifiedBoard[0][2].equals("_")) {
            if(modifiedBoard[2][0].equals(ai)){
                return 10;
            }
            else{
                return  -10;
            }
        }
        return 0;
    }
    private int minMax(String [][] board, String player, int depth){
        int val = win(board);
        if(val == 10 || val == -10){
            return  val;
        }
        else if(!findEmpty(board)){
            return 0;
        }
        if (player.equals(ai))
        {
            int best = -1000;
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {

                    if (board[i][j].equals("_"))
                    {

                        board[i][j] = player;
                        best = Math.max(best, minMax(board, opponent, depth+1));
                        board[i][j] = "_";
                    }
                }
            }
            return best;
        }

        else
        {
            int best = 1000;
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    if (board[i][j].equals("_"))
                    {
                        board[i][j] = opponent;
                        best = Math.min(best, minMax(board, ai, depth+1));
                        board[i][j] = "_";
                    }
                }
            }
            return best;
        }
    }
    private boolean findEmpty(String [][] board){
        for (int i = 0; i< board.length; i++){
            for (int j = 0; j< board.length; j++){
                if(board[i][j].equals("_")){
                    return true;
                }
            }
        }
        return false;
    }
    private String [][] copyBoard(String[][] board){
        String [][] tmpBoard = new String[3][3];
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j< board[i].length; j++){
                tmpBoard[i][j] = board[i][j];
            }

        }
        return tmpBoard;
    }

}
