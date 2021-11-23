package tictactoe;

public class Player {
    protected boolean correct;
    protected int cordX;
    protected int cordY;
    protected int max;
    protected int min;
    protected int range;

    public Player(){
        this.correct = false;
        this.cordX = 3;
        this.cordY = 3;
        this.max = 3;
        this.min = 1;
        this.range = this.max - this.min +1;

    }
    protected void makeAMove(String[][] board, String move){
    }
}
