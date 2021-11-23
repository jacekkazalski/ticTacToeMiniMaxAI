package tictactoe;

public class MediumAI extends Player {
    private boolean notRandom = false;

    @Override
    protected void makeAMove(String[][] board, String move) {
        correct = false;

        while (!correct) {


            cordX = (int) (Math.random() * range) + min;
            cordY = (int) (Math.random() * range) + min;
            correct = true;
            decide(board,move);
            if (!board[cordX - 1][cordY - 1].equals("_")) {
                correct = false;
            }
            if (correct) {
                System.out.println("Making move level \"medium\"");
                board[cordX - 1][cordY - 1] = move;

            }
        }
    }
    private void decide(String [][] board, String currentMove){
        String opponent = "O";
        if(currentMove.equals("O")){
            opponent = "X";
        }
        if(fill(board,currentMove)){
            return;
        }
        else if(fill(board,opponent)){
            return;
        }
    }

    private boolean fill(String [][] board, String currentMove){
        String [][] tmpBoard = new String[3][3];
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j< board[i].length; j++){
                tmpBoard[i][j] = board[i][j];
            }

        }
        boolean move = false;
        for(int i = 0; i < tmpBoard.length; i++){
            for(int j = 0; j< tmpBoard.length; j++){
                if(tmpBoard[i][j].equals("_")){
                    tmpBoard[i][j] = currentMove;
                    move = analyze(tmpBoard);
                    if (move){
                        cordX = i+1;
                        cordY = j+1;
                        correct = true;
                        return  true;
                    }
                    else{
                        for(int k = 0; k< board.length; k++){
                            for(int l = 0; l< board[k].length; l++){
                                tmpBoard[k][l] = board[k][l];
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean analyze(String[][] boardAnal) {
        for (int i = 0; i < boardAnal.length; i++) {

            if (boardAnal[i][0].equals(boardAnal[i][1]) && boardAnal[i][0].equals(boardAnal[i][2]) && !boardAnal[i][0].equals("_")) {
                return true;
            } else if (boardAnal[0][i].equals(boardAnal[1][i]) && boardAnal[0][i].equals(boardAnal[2][i]) && !boardAnal[0][i].equals("_")) {
                return true;
            }
        }
        if (boardAnal[0][0].equals(boardAnal[1][1]) && boardAnal[1][1].equals(boardAnal[2][2]) && !boardAnal[0][0].equals("_")) {
            return true;
        } else if (boardAnal[2][0].equals(boardAnal[1][1]) && boardAnal[2][0].equals(boardAnal[0][2]) && !boardAnal[0][2].equals("_")) {
            return true;
        }
        return false;
    }
}

