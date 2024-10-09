
package dk.easv.tictactoe.bll;


import java.util.Arrays;

import java.util.List;

/**
 * @author EASV
 */
public class GameBoard implements IGameBoard {
    List<Player> players = Arrays.asList(new Player(1, "X"), new Player(2, "O"));
    Player currentPlayer = players.get(0);
    public int turn = 0;

    public void switchPlayer() {
        if (turn % 2 == 0) {
            currentPlayer = players.get(0); //player 1
            System.out.println("Switched to player 1:");
        } else {
            currentPlayer = players.get(1); // player 2
            System.out.println("Switched to player 2:");
        }
    }


    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */


    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */

    public int boardWidth = 3;
    public int boardHeight = 3;
    private final String[][] board = new String[boardWidth][boardHeight];

    @Override
    public int getNextPlayer() {
        return 0;
    }

    public boolean play(int col, int row) {
        if (isGameOver()) {
            return false;
        }
        if (col < 0 || col >= boardWidth || row < 0 || row >= boardHeight) {
            return false;
        }
        if (board[row][col] == null) {
            board[row][col] = currentPlayer.getSymbol();
            System.out.println("Placing Symbol: " + currentPlayer.getSymbol() + " at (" + row + ", " + col + ")");
            turn++;
            switchPlayer();

            return true;
        } else {
            return false;
        }
    }
    //Gem til senere? Måske til win condition stedet? looooooop'de'loop
        /* for (int i = boardHeight - 1; i >= 0; i--) {
            if (board[i][col] == null) {
                board[i][col] == currentPlayer.getid() = 1 ? "X" : "O";
                break;
        }

        }
        */
       /* switchPlayer();
    {

        //TODO Implement this method
        return true;
    }
/*
    /**
     * Tells us if the game has ended either by draw or by meeting the winning
     * condition.
     *
     * @return true if the game is over, else it will retun false.
     */
    public boolean isGameOver() {
        return getWinner() != -1;
    }

    @Override
    public int getWinner() {

        for (int row = 0; row < boardHeight; row++) {
            if (board[row][0] != null && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                return currentPlayer.getPlayerNumber();
            }
        }
        for (int col = 0; col < boardWidth; col++) {
            if (board[0][col] != null && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                return currentPlayer.getPlayerNumber();
            }
        }
        if (board[0][0] != null && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return currentPlayer.getPlayerNumber();
        }
        if (board[0][2] != null && board[0][2] == board[1][1] && board[1][1] == board[2][2]) {
            return currentPlayer.getPlayerNumber();
        }
        for (int row = 0; row < boardHeight; row++) {
            for (int col = 0; col < boardWidth; col++) {
                if (board[row][col] == null) {
                    return -1;
                }
            }
        }
        return -1;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    /*
    public static int getWinner() //there can only be one

    {
        //TODO Implement this method
        return -1;
    }
*/

    /**
     * Resets the game to a new game state.
     */
    public void newGame() {

        //private char[][] board = new char[3][3];
        //loop, der nulstiller spilbrættet til nyt spil - A
        for (int row = 0; row < boardHeight; row++) {
            for (int col = 0; col < boardWidth; col++) {
                board[row][col] = null;
            }
        }
        currentPlayer = players.get(0);
    }
}