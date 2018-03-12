package tictactoe;

import java.util.Scanner;
import javax.swing.JButton;

public class Main {

    public static boolean player1Turn = true;
    public static boolean playAgain = false;
    public static GameResultEnum gameResult = null;

    public static Scanner scan = new Scanner(System.in);

    public static TicTacToe board = new TicTacToe();

    public static void main(String[] args) {
            board.setVisible(true);
    }

    public static void checkForWin() {
        if (nobodyWon()) {
        } else if (weHaveVictoryHere(0, 3, 6, "X")) {
        } else if (weHaveVictoryHere(1, 4, 7, "X")) {
        } else if (weHaveVictoryHere(2, 5, 8, "X")) {
        } else if (weHaveVictoryHere(0, 1, 2, "X")) {
        } else if (weHaveVictoryHere(3, 4, 5, "X")) {
        } else if (weHaveVictoryHere(6, 7, 8, "X")) {
        } else if (weHaveVictoryHere(0, 4, 8, "X")) {
        } else if (weHaveVictoryHere(2, 4, 6, "X")) {
        } else if (weHaveVictoryHere(0, 3, 6, "O")) {
        } else if (weHaveVictoryHere(1, 4, 7, "O")) {
        } else if (weHaveVictoryHere(2, 5, 8, "O")) {
        } else if (weHaveVictoryHere(0, 1, 2, "O")) {
        } else if (weHaveVictoryHere(3, 4, 5, "O")) {
        } else if (weHaveVictoryHere(6, 7, 8, "O")) {
        } else if (weHaveVictoryHere(0, 4, 8, "O")) {
        } else if (weHaveVictoryHere(2, 4, 6, "O")) {
        }

        if (gameResult != null) {
            board.setVisible(false);
            System.out.println("Would you like play again? true or false");
            playAgain = scan.nextBoolean();
            if (playAgain) {
                for (JButton btn : board.button) {
                    btn.setText("");
                }

                player1Turn = true;
                gameResult = null;
                board.setVisible(true);
            } else {
                System.out.println("Thanks for playing...");
            }
        }
    }

    private static boolean weHaveVictoryHere(int i1, int i2, int i3, String sign) {
        if (board.button[i1].getText().equals(sign)
                && board.button[i2].getText().equals(sign)
                && board.button[i3].getText().equals(sign)) {
            gameResult = sign.equals("X") ? GameResultEnum.player1Won : GameResultEnum.player2Won;
            System.out.println("Player " + (sign.equals("X") ? "1" : "2") + " Won!");

            return true;
        } else {
            return false;
        }
    }

    private static boolean nobodyWon() {
        int i = 0;
        for (i = 0; i < board.button.length; i++) {
            if (board.button[i].getText().equals("")) {
                break;
            }
        }
        if (i == 9) {
            gameResult = GameResultEnum.nobodyWon;
            System.out.println("Nobody won!");
            return true;
        } else {
            return false;
        }
    }
}
