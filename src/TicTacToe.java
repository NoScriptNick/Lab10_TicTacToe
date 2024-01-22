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
        boolean donePlayerOne = false;
        boolean donePlayerTwo = false;
        int playerOneMoveRow = -1;
        int playerOneMoveCol = -1;
        int playerTwoMoveRow = -1;
        int playerTwoMoveCol = -1;
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

        //remember to reset playerOne and playerTwo moves
        while (!isWin(playerOne) && !isWin(playerTwo)) {
            while (!donePlayerOne){
                playerOneMoveRow = InputHelper.getRangedInt(scan, "Player One, pick a row for your move", 1, 3);
                playerOneMoveCol = InputHelper.getRangedInt(scan, "Player One, pick a column for your move", 1, 3);
                if (isValidMove(playerOneMoveRow, playerOneMoveCol)) {
                    donePlayerOne = true;
                }
            }
            board[playerOneMoveRow][playerOneMoveCol] = playerOne;
            playerOneMoveCol = -1;
            playerOneMoveRow = -1;
            while (!donePlayerTwo){
                playerTwoMoveRow = InputHelper.getRangedInt(scan, "Player Two, pick a row for your move", 1, 3);
                playerTwoMoveCol = InputHelper.getRangedInt(scan, "Player Two, pick a column for your move", 1, 3);
                if (isValidMove(playerTwoMoveRow, playerTwoMoveCol)) {
                    donePlayerTwo = true;
                }
            }
            board[playerTwoMoveRow][playerTwoMoveCol] = playerTwo;
            playerTwoMoveCol = -1;
            playerTwoMoveRow = -1;
            if (isWin(playerOne)) {
                System.out.println("Player One Wins!");
            } else if (isWin(playerTwo)) {
                System.out.println("Player Two Wins!");
            }
        }

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
        boolean valid = false;
        if (board[row][col] == "-") {
            valid = true;
        }
        return valid;
    }

    private static boolean isWin(String player){
        boolean win = false;
        //checks to see if there is a win state on the current board for the specified player (X or O)
        // This method in turn calls three additional methods (isColWin, isRowWin, isDiagonalWin) that break down the 3 kinds of wins that are possible.
        return win;
    }

    private static boolean isColWin(String player){
        boolean colWin = false;
        //checks for a col win for specified player
        return colWin;
    }

    private static boolean isRowWin(String player){
        boolean rowWin = false;
        //checks for a row win for the specified player
        return rowWin;
    }

    private static boolean isDiagonalWin(String player){
        boolean diagWin = false;
        //checks for a diagonal win for the specified player
        return diagWin;
    }

    private static boolean isTie(){
        boolean tie = false;
        //checks for a tie condition: all spaces on the board are filled and no win has occurred
        return tie;
    }

}