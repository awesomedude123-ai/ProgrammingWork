package View;

import javax.swing.*;

public class QueueModelForm {
    private JPanel myPanel;
    private JLabel queueContentsLabel;
    private JTextField enqueueTextField;
    private JButton enqueueButton;
    private JButton dequeueButton;
    private JLabel frontLabel;
    private JLabel frontLabelValue;
    private JLabel rearLabel;
    private JLabel rearLabelValue;
    private JButton saveButton;
    private JButton clearLoadButton;
    private JButton undoButton;

    public JPanel getMyPanel() {
        return myPanel;
    }

    public JLabel getQueueContentsLabel() {
        return queueContentsLabel;
    }

    public JTextField getEnqueueTextField() {
        return enqueueTextField;
    }

    public JButton getEnqueueButton() {
        return enqueueButton;
    }

    public JButton getDequeueButton() {
        return dequeueButton;
    }

    public JLabel getFrontLabel() {
        return frontLabel;
    }

    public JLabel getFrontLabelValue() {
        return frontLabelValue;
    }

    public JLabel getRearLabel() {
        return rearLabel;
    }

    public JButton getUndoButton() {
        return undoButton;
    }

    public JLabel getRearLabelValue() {
        return rearLabelValue;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getClearLoadButton() {
        return clearLoadButton;
    }
}
