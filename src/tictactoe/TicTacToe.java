package tictactoe;

public class TicTacToe {
    private Player playerOne;
    private Player playerTwo;
    private String [][] board;

    public TicTacToe(Player playerOne, Player playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        //TODO sztuczna tablica
        this.board = new String[3][3];

        for(int i = 0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "_";
            }
        }

    }
    public void play(){
        boolean finished = false;
        boolean draw = false;
        printBoard(board);
        String move = "X";
        while(!finished) {
            //making a move
            if (move.equals("X")) {
                playerOne.makeAMove(board,move);
            }
            else{
                playerTwo.makeAMove(board,move);
            }
            //printing the game
            printBoard(board);
            //analysis v2
            finished = analyze(board,finished,draw,move);
            //turn change
            if(move.equals("X")){
                move = "O";
            }
            else{
                move = "X";
            }
        }
    }

    private void printBoard(String[][] board){
        System.out.println("---------");
        for (int i = 0; i < board.length; i++) {
            System.out.println("| " + board[i][0] + " " + board[i][1] + " " + board[i][2] + " |");
        }
        System.out.println("---------");
    }

    private boolean analyze(String [][] board, boolean finished, boolean draw, String move){
        for(int i = 0; i < board.length; i++){

            if(board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && !board[i][0].equals("_") ){
                finished = true;
            }
            else if(board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && !board[0][i].equals("_")){
                finished = true;
            }
        }
        if(board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals("_")){
            finished = true;
        }
        else if(board[2][0].equals(board[1][1]) && board[2][0].equals(board[0][2]) && !board[0][2].equals("_")){
            finished = true;
        }
        if(!finished){
            draw = true;
            for(String [] sArr : board){
                for (String s : sArr){
                    if (s.equals("_")){
                        draw = false;
                    }
                }
            }
        }
        if (draw){
            finished = true;
        }
        if(finished && draw){
            System.out.println("Draw");
        }
        else if(finished){
            System.out.println(move+" wins");
        }
        return finished;
    }
}
