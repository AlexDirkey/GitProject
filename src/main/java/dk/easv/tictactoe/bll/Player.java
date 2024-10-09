package dk.easv.tictactoe.bll;

public class Player {
    public int playerNumber;
    private String symbol;



    public Player(int playerNumber, String symbol) {
        this.playerNumber = playerNumber;
        this.symbol = symbol;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }
    public String getSymbol() {
        return symbol;
    }
}