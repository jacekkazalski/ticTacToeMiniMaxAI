package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User extends Player{
    @Override
    public void makeAMove(String[][] board, String move) {
        Scanner scanner = new Scanner(System.in);
        correct = false;
        while(!correct){
            correct = true;
            System.out.print("Enter the coordinates: ");
            try {
                cordX = scanner.nextInt();
                cordY = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                correct = false;
                scanner.nextLine();
            }

            if (cordY > 3 || cordY < 1 || cordX > 3 || cordX < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                correct = false;

            } else if (board[cordX - 1][cordY - 1].equals("X") || board[cordX - 1][cordY - 1].equals("O")) {
                System.out.println("This cell is occupied! Choose another one!");
                correct = false;
            }
            if (correct) {
                board[cordX - 1][cordY - 1] = move;

            }
        }
    }
}
