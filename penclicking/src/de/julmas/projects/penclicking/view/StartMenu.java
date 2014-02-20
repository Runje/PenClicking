/**
 * 
 */
package de.julmas.projects.penclicking.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import de.julmas.projects.penclicking.controller.PenController;
import de.julmas.projects.penclicking.controller.StateMachine;

/**
 * Class for startmenu
 * @author jmayer
 *
 */
public class StartMenu extends JFrame implements ActionListener {
    private static final long serialVersionUID = 6521284621749651308L;
    private static final String START_COMMAND = "START";
    private static final String OPTIONS_COMMAND = "OPTIONS";
    private static final String QUIT_COMMAND = "QUIT";
    private StateMachine stateMachine;

    public StartMenu(StateMachine stateMachine) {
        this.stateMachine = stateMachine;

        final int frameSizeX = 150;
        final int frameSizeY = 150;

        this.setSize(frameSizeX, frameSizeY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("PenClicking");

        JButton btnStart = new JButton("Start");
        btnStart.setActionCommand(START_COMMAND);
        btnStart.setPreferredSize(this.getSize());
        btnStart.addActionListener(this);

        JButton btnOptions = new JButton("Options");
        btnOptions.setActionCommand(OPTIONS_COMMAND);
        btnOptions.setPreferredSize(this.getSize());
        btnOptions.addActionListener(this);

        JButton btnQuit = new JButton("Quit");
        btnQuit.setActionCommand(QUIT_COMMAND);
        btnQuit.setPreferredSize(this.getSize());
        btnQuit.addActionListener(this);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(btnStart);
        mainPanel.add(btnOptions);
        mainPanel.add(btnQuit);

        this.getContentPane().add(mainPanel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
        case START_COMMAND:
            stateMachine.nextState();
            break;
        case OPTIONS_COMMAND:
            stateMachine.menuToOptions();
        	break;
        case QUIT_COMMAND:
            this.dispose();
            System.exit(0);
            break;
        default:
            break;
        }
    }
}
