
public class Board {
    // members
    private BoardSquare[][] board;

    // basic constructor, makes 3x3 board
    public Board() {
        this.board = new BoardSquare[3][3];
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                this.board[i][j] = new BoardSquare();
            }
        }
    }

    // parameterized constructor, makes nxn board
    public Board(int n) {
        this.board = new BoardSquare[n][n];
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                this.board[i][j] = new BoardSquare();
            }
        }
    }

    public void printBoard() {
        for (BoardSquare[] row : this.board) {
            for (BoardSquare square : row) {
                square.printBoardSquare();
                if (square.getSymbol() == ' ' && square != row[row.length - 1]) {
                    System.out.print(" |");
                } else if (square != row[row.length - 1]) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row != this.board[this.board.length - 1]) {
                printHorizontalLine();
            }
        }
    }

    public void printHorizontalLine() {
        System.out.println("--|--|--");
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.printBoard();
    }
}