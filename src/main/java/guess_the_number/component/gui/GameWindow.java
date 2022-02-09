package guess_the_number.component.gui;
/*
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
import guess_the_number.component.DataPrinter;
import guess_the_number.component.GameOverHandler;
import guess_the_number.component.Input;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public final class GameWindow extends JFrame implements DataPrinter, Input, GameOverHandler {

    private static final int FONT_SIZE = 35;

    private static final int CELL_SIZE = 75;

    private int clickedNumber;

    public GameWindow() {
        super("Guess the number");
        setSystemLookAndFeel();
        setLayout(new GridLayout(2, 5));
        createGameTable();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        displayInTheMiddleOfTheScreen();
    }

    private void setSystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (final ClassNotFoundException | UnsupportedLookAndFeelException |
                IllegalAccessException | InstantiationException ex) {
            ex.printStackTrace();
        }
    }

    private void createGameTable() {
        for (int i = 0; i < 10; i++) {
            final JLabel label = new JLabel();
            label.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(new Font(Font.SERIF, Font.PLAIN, FONT_SIZE));
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            label.setText(String.valueOf(i));
            add(label);
            final int number = i;
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(final MouseEvent unused) {
                    synchronized (GameWindow.this) {
                        clickedNumber = number;
                        GameWindow.this.notifyAll();
                    }
                }
            });
        }
    }

    private void displayInTheMiddleOfTheScreen() {
        final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
        setVisible(true);
    }

    @Override
    public void printInfoMessage(final String message) {
        JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    @Override
    public void printInstructions() {
        printInfoMessage("Please type a number between 0 and 9:");
    }

    @Override
    public void printErrorMessage(final String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public int guess() {
        synchronized (this) {
            try {
                wait();
            } catch (final InterruptedException exception) {
                exception.printStackTrace();
                System.exit(2);
            }
        }
        return clickedNumber;
    }

    @Override
    public void gameOver() {
        System.exit(0);
    }
}

