
public class BoardSquare {
    private boolean isOccupied;
    private char symbol;

    // basic constructor
    public BoardSquare() {
        this.isOccupied = false;
        this.symbol = ' ';
    }

    // parameterized constructor
    public BoardSquare(boolean isOccupied, char symbol) {
        this.isOccupied = isOccupied;
        this.symbol = symbol;
    }

    public void printBoardSquare() {
        System.out.print(this.symbol);
    }

    // getters and setters
    public boolean isOccupied() {
        return this.isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

}
