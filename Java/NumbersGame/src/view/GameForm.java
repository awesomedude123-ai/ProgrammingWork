package view;

import javax.swing.*;

public class GameForm {
    private JPanel Panel;
    private JTextField guessField;
    private JButton guessButton;
    private JButton regenerateButton;
    private JButton resetButton;
    private JLabel scoreLabel;
    private JLabel scoreValue;
    private JLabel guessLabel;
    private JLabel guessValue;
    private JLabel lowestGuessValue;
    private JLabel lowestGuessLabel;
    private JButton instructionsButton;

    public JPanel getPanel() {
        return Panel;
    }

    public JTextField getGuessField() {
        return guessField;
    }

    public JButton getGuessButton() {
        return guessButton;
    }

    public JButton getRegenerateButton() {
        return regenerateButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public JLabel getScoreValue() {
        return scoreValue;
    }

    public JLabel getGuessLabel() {
        return guessLabel;
    }

    public JLabel getGuessValue() {
        return guessValue;
    }

    public JLabel getLowestGuessValue() {
        return lowestGuessValue;
    }

    public JLabel getLowestGuessLabel() {
        return lowestGuessLabel;
    }

    public JButton getInstructionsButton() {
        return instructionsButton;
    }
}
