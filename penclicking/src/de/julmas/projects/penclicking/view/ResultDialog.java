package de.julmas.projects.penclicking.view;

import java.awt.BorderLayout;
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
 * Result dialog to show final clickcout and name.
 * @author jmayer
 *
 */
public class ResultDialog extends JDialog implements ActionListener {
    private static final long serialVersionUID = 237188639435169043L;
    private GameFrame gameFrame;

    /**
     * Constructor starts frame.
     * @param penController to load click count.
     * @param gameFrame to close it on result close.
     */
    public ResultDialog(PenController penController, GameFrame gameFrame) {
        this.gameFrame = gameFrame;

        this.setTitle("Result");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblName = new JLabel("name");
        JLabel lblClicks = new JLabel("Clicks:");

        JTextField txtName = new JTextField();
        txtName.setText(penController.getName());
        txtName.setEnabled(false);

        JTextField txtClicks = new JTextField();
        txtClicks.setText(String.valueOf(penController.getClicks()));
        txtClicks.setEnabled(false);

        JButton btnBack = new JButton("back");
        btnBack.addActionListener(this);

        JPanel buttonPanel;
        buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(btnBack, BorderLayout.CENTER);

        JPanel resultPanel;
        resultPanel = new JPanel(new GridLayout(2, 2));
        resultPanel.add(lblName);
        resultPanel.add(txtName);
        resultPanel.add(lblClicks);
        resultPanel.add(txtClicks);

        JPanel mainPanel;
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(new JLabel("You've done it!"));
        mainPanel.add(resultPanel);
        mainPanel.add(buttonPanel);

        this.getContentPane().add(mainPanel);
        this.pack();
        this.setModal(true);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO save highscore
        this.dispose();
        this.gameFrame.dispose();
    }

}
