package de.julmas.projects.penclicking.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.julmas.projects.penclicking.controller.PenController;

/**
 * Options menu to change player name an timeout time.
 * @author jmayer
 * 
 */
public class OptionsMenu extends JDialog implements ActionListener {

    private static final long serialVersionUID = 8179854126221798775L;
    private static final String SAVE_ACTION = "SAVE";
    private static final String CANCEL_ACTION = "CANCEL";
    private static final int optionsWidth = 20;
    private PenController penController;
    private JTextField txtTimeout;
    private JTextField txtName;

    /**
     * Constructor starts Frame.
     * 
     * @param penController
     *            needed to save and load options.
     */
    public OptionsMenu(PenController penController) {
        this.penController = penController;

        this.setTitle("Options");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblTimeout = new JLabel("Timeout (sec):");
        JLabel lblName = new JLabel("name");

        long timeoutInSec = this.penController.getTimeout() / 1000;
        this.txtTimeout = new JTextField(String.valueOf(timeoutInSec), optionsWidth);
        this.txtName = new JTextField(this.penController.getName(), optionsWidth);

        JButton btnSave = new JButton("Save");
        btnSave.setActionCommand(SAVE_ACTION);
        btnSave.setSelected(true);
        btnSave.addActionListener(this);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setActionCommand(CANCEL_ACTION);
        btnCancel.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(btnSave);
        buttonPanel.add(btnCancel);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(lblName);
        inputPanel.add(this.txtName);
        inputPanel.add(lblTimeout);
        inputPanel.add(this.txtTimeout);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(inputPanel);
        mainPanel.add(buttonPanel);

        this.getContentPane().add(mainPanel);
        this.pack();
        this.setModal(true);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(SAVE_ACTION)) {
            this.penController.setName(this.txtName.getText());
            Long timeout = Long.valueOf(this.txtTimeout.getText()) * 1000;
            this.penController.setTimeout(timeout);
        }
        //dispose in any case (SAVE and CANCEL)
        this.dispose();
    }
}
