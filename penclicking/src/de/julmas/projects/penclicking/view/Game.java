package de.julmas.projects.penclicking.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

import de.julmas.projects.penclicking.controller.PenController;
import de.julmas.projects.penclicking.controller.StateMachine;
import de.julmas.projects.penclicking.util.observer.IObserver;

/**
 * Main GameFrame which visualizes the pen.
 * @author jmayer
 *
 */
public class Game extends JWindow implements IObserver, ActionListener {

    private static final long serialVersionUID = -8853165778158196157L;
    private JLabel lblClickcount;
    private PenController penController;
    private JButton btnClickPen;
    private JButton btnClose;
    StateMachine stateMachine;

    /**
     * Constructor start Frame.
     * @param penController controller to handle input.
     * @param startMenu needed to set focus after termination.
     */
    public Game(PenController penController, StateMachine stateMachine) {
        this.penController = penController;
        this.stateMachine = stateMachine;
        this.penController.addObserver(this);
        this.penController.init();
        this.initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private final void initialize() {

    	this.setSize(300,300);
    	this.setLocation(500,100);
        this.btnClickPen = new JButton("Click");
        this.btnClickPen.addActionListener(this.penController);
        
        this.btnClose = new JButton("Cancel");
        this.btnClose.addActionListener(this);
        this.lblClickcount = new JLabel("Clickcount:");
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(this.btnClickPen, BorderLayout.CENTER);
        mainPanel.add(this.lblClickcount, BorderLayout.NORTH);
        mainPanel.add(this.btnClose, BorderLayout.SOUTH);
        this.getContentPane().add(mainPanel);	
		this.setVisible(true);
    }

    @Override
    public void update() {
        if (this.penController.isFinish()) {
            this.btnClickPen.setEnabled(false);
            stateMachine.nextState();
        } else {
            int clicks = this.penController.getClicks();
            if (clicks == 0) {
                this.btnClickPen.setText("Click pen");
            } else {
                this.lblClickcount.setText("Clickcount: " + clicks);
            }
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		this.stateMachine.ingameToMenu();
	}
}
