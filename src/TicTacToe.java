import jdk.nashorn.internal.ir.WhileNode;

import java.util.Scanner;
public class TicTacToe {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static final String [][] board = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String playerOne = "";
        String playerTwo = "";
        boolean done = false;
        String temp;


        while (!done) {
            temp = InputHelper.getNonZeroLenString(scan, "Player 1, choose X or O");
            if (temp.equalsIgnoreCase("X")) {
                playerOne = "X";
                playerTwo = "O";
                done = true;
            } else if (temp.equalsIgnoreCase("O")) {
                playerOne = "O";
                playerTwo = "X";
                done = true;
            } else {
                System.out.println("Invalid");
            }
        }

        clearBoard();
        displayBoard();

        //When asking each player for their move, ask them for a row [1-3] and column [1-3]. These values will need to be shifted since the indices start at 0.
        //Your InputHelper methods should be utilized to ensure that valid values within the given range are collected.
        //Any time a player makes a move, your program should check to see if a win or tie has occurred. Keep in mind that you will write multiple methods to check for different types of wins.
        //Your program should display the new board any time a player makes a move.
        //When a tie or win occurs, the game should stop and display a message declaring the winner.
        //Your program should then ask the user if they would like to play another game.

    }

    private static void clearBoard(){
        for (int r = 0; r<board.length; r++) {
            for (int c = 0; c<board[0].length; c++) {
                board[r][c] = "-";
            }
        }
    }

    private static void displayBoard(){
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int col){
        //returns true if there is a space at the given proposed move coordinates which means it is a legal move
        //Returns false otherwise
        boolean valid = false;
        if (row > 0 && row < 4 && col > 0 && col < 4) {
            valid = true;
        }
        return valid;
    }

    private static boolean isWin(String player){
        //checks to see if there is a win state on the current board for the specified player (X or O)
        // This method in turn calls three additional methods (isColWin, isRowWin, isDiagonalWin) that break down the 3 kinds of wins that are possible.
    }

    private static boolean isColWin(String player){
        //checks for a col win for specified player
    }

    private static boolean isRowWin(String player){
        //checks for a row win for the specified player
    }

    private static boolean isDiagonalWin(String player){
        //checks for a diagonal win for the specified player
    }

    private static boolean isTie(){
        //checks for a tie condition: all spaces on the board are filled and no win has occurred
    }

}