package src;

public class Board {
    // members
    private BoardSquare[][] board;
    private int size;

    private Player currentPlayer;
    private Player[] players;

    // basic constructor, makes 3x3 board
    public Board() {
        this.size = 3;
        this.board = new BoardSquare[3][3];
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                this.board[i][j] = new BoardSquare();
            }
        }
    }

    // parameterized constructor, makes nxn board
    public Board(int n) {
        this.size = n;
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

    public int getSize() {
        if (this.size == 0) {
            throw new IllegalArgumentException("Board size is 0");
        }
        return this.size;
    }

    public BoardSquare[][] getBoard() {
        return this.board;
    }

    public BoardSquare getSquare(int x, int y) {
        return this.board[x][y];
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    public void addNewPlayer(Player player) {
        if (this.players == null) {
            this.players = new Player[1];
            this.players[0] = player;
        } else {
            Player[] newPlayers = new Player[this.players.length + 1];
            for (int i = 0; i < this.players.length; i++) {
                newPlayers[i] = this.players[i];
            }
            newPlayers[this.players.length] = player;
            this.players = newPlayers;
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.printBoard();
    }
}