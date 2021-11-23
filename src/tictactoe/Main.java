package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //menu
        while(true){
            System.out.print("Input command: ");
            Scanner scanner = new Scanner(System.in);
            String [] input = scanner.nextLine().split(" ");
            if(input[0].equals("exit")){
                break;
            }
            else if(input[0].equals("start")){
                try{
                    Player one = null;
                    Player two = null;
                    if(input[1].equals("user")){
                        one = new User();
                    }
                    else if (input[1].equals("easy")){
                        one = new EasyAI();
                    }
                    else if (input[1].equals("medium")){
                        one = new MediumAI();
                    }
                    else if (input[1].equals("hard")){
                        one = new HardAI();
                    }
                    if(input[2].equals("user")){
                        two = new User();
                    }
                    else if (input[2].equals("easy")){
                        two = new EasyAI();
                    }
                    else if (input[2].equals("medium")){
                        two = new MediumAI();
                    }
                    else if (input[2].equals("hard")){
                        two = new HardAI();
                    }
                    TicTacToe game = new TicTacToe(one,two);
                    game.play();
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("Bad parameters!");

                }
            }
            else{
                System.out.println("Bad parameters!");
            }
        }

    }
}
