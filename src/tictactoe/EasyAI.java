package tictactoe;

public class EasyAI extends Player{

    @Override
    public void makeAMove(String[][] board, String move) {
        correct = false;
        while(!correct) {
            correct = true;
            cordX = (int) (Math.random() * range) + min;
            cordY = (int) (Math.random() * range) + min;
            if (board[cordX - 1][cordY - 1].equals("X") || board[cordX - 1][cordY - 1].equals("O")) {
                correct = false;
            }
            if (correct) {
                System.out.println("Making move level \"easy\"");
                board[cordX - 1][cordY - 1] = move;

            }
        }
    }
}
