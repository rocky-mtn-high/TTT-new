package src;

import javax.swing.*;
import java.awt.*;

public class BoardGUI extends JFrame {
    private Board board;

    public BoardGUI(Board board) {
        this.board = board;
        // Create and set up the window.
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        this.setVisible(true);

        TicTacToePanel ticTacToePanel = new TicTacToePanel();
        ticTacToePanel.setLayout(new GridLayout(3, 3));

        frame.add(ticTacToePanel);

        int boardSize = this.board.getSize();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                JButton button = new JButton();
                button.addActionListener(new SquareListener(board, this));

                int buttonSize = Math.min(getWidth(), getHeight()) / board.getSize();
                buttonSize = Math.round(buttonSize);
                int x = i * getWidth() / boardSize;
                int y = j * getHeight() / boardSize;

                button.setOpaque(false);
                button.setContentAreaFilled(false);
                button.setBorderPainted(false);
                button.setBounds(x, y, buttonSize, buttonSize);
                ticTacToePanel.add(button);
            }
        }

        frame.setLocationRelativeTo(null);
        // frame.pack();
        frame.setVisible(true);
    }

    public void updateGUI() {
        // Update the GUI display
    }

    private class TicTacToePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int squareSize = Math.min(getWidth(), getHeight()) / board.getSize();
            squareSize = Math.round(squareSize);

            // Horizontal lines
            for (int i = 1; i < board.getSize(); i++) {
                int y = i * getHeight() / board.getSize();
                g.drawLine(0, y, getWidth(), y);
            }

            // Vertical lines
            for (int j = 1; j < board.getSize(); j++) {
                int x = j * getWidth() / board.getSize();
                g.drawLine(x, 0, x, getHeight());
            }

            // for (int i = 0; i < board.getSize(); i++) {
            // for (int j = 0; j < board.getSize(); j++) {
            // int x = i * getWidth() / board.getSize();
            // int y = j * getHeight() / board.getSize();

            // board.getBoard()[i][j].paintSquare(g, x, y, squareSize);
            // }
            // }
        }
    }

}
