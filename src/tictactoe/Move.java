package tictactoe;

public class Move {
    int score;
    public Move(){
        score =0;
    }
    public void changeScore(int value){
        this.score += value;
    }
}
