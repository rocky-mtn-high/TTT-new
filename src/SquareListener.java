package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Point;
import javax.swing.JButton;

public class SquareListener implements ActionListener {
    private Board board;
    private BoardGUI boardGUI;

    public SquareListener(Board board, BoardGUI boardGUI) {
        super();
        this.board = board;
        this.boardGUI = boardGUI;
    }

    public void actionPerformed(ActionEvent e) {
        if (!boardGUI.isVisible()) {
            throw new IllegalArgumentException("BoardGUI is not visible");
        }

        if (boardGUI.getWidth() == 0 || boardGUI.getHeight() == 0) {
            throw new IllegalArgumentException("BoardGUI width or height is 0");
        }
        // get which square was clicked

        JButton clickedButton = (JButton) e.getSource();
        Point clickedButtonLocation = clickedButton.getLocation();
        int row = (int) (clickedButtonLocation.getX() / (boardGUI.getWidth() / board.getSize()));
        int col = (int) (clickedButtonLocation.getY() / (boardGUI.getHeight() / board.getSize()));

        System.out.println("row: " + row + ", col: " + col);
        BoardSquare clickedSquare = null;
        if (row >= 0 && row < board.getSize() && col >= 0 && col < board.getSize()) {
            clickedSquare = board.getBoard()[row][col];
        } else {
            throw new IllegalArgumentException("Square is out of bounds: " + row + ", " + col);
        }

        // check if square is empty
        if (clickedSquare.getSymbol() == ' ') {
            // get current player and their symbol
            Player currentPlayer = board.getCurrentPlayer();
            char currentSymbol = currentPlayer.getSymbol();

            // Update the board
            clickedSquare.setSymbol(currentSymbol);

            // Update the GUI
            clickedButton.setText(Character.toString(currentSymbol));
            boardGUI.updateGUI();

            // get current player and their symbol
            // Update the board
            // Update the GUI
        }
    }

}
