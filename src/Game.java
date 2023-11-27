package src;

//Game class that contains the board and prints it out
public class Game {
    private Board board;

    public void play() {
        this.board = new Board();
        BoardGUI boardGUI = new BoardGUI(board);
        PlayerGUI playerGUI = new PlayerGUI(board);

        Player player1 = new Player("Player 1");
        player1.setSymbol('X');
        Player player2 = new Player("Player 2");
        player2.setSymbol('O');
        board.addNewPlayer(player1);
        board.addNewPlayer(player2);
        board.setCurrentPlayer(player1);

    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();

    }
}
