package src;

public class Player {
    // name
    private String name;
    // current symbol
    private char symbol;

    // switch priviledges
    private boolean canSwitch;

    public Player() {
        this.name = "Player";
        this.symbol = ' ';
        this.canSwitch = false;

    }

    public Player(String name) {
        this.name = name;
    }

    public void giveSwitchPriviledges() {
        this.canSwitch = true;
    }

    public void takeSwitchPriviledges() {
        this.canSwitch = false;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
