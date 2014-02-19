package de.julmas.projects.penclicking.view;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.julmas.projects.penclicking.controller.PenController;
import de.julmas.projects.penclicking.util.observer.IObserver;

/**
 * Main GameFrame which visualizes the pen.
 * @author jmayer
 *
 */
public class GameFrame extends JFrame implements IObserver, WindowStateListener {

    private static final long serialVersionUID = -8853165778158196157L;
    private JLabel lblClickcount;
    private PenController penController;
    private StartMenu startMenu;
    private JButton btnClickPen;

    /**
     * Constructor start Frame.
     * @param penController controller to handle input.
     * @param startMenu needed to set focus after termination.
     */
    public GameFrame(PenController penController, StartMenu startMenu) {
        this.penController = penController;
        this.penController.addObserver(this);
        this.penController.init();
        this.startMenu = startMenu;
        this.addWindowStateListener(this);
        this.initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private final void initialize() {
        this.setTitle("Click it, bitch!");
        this.setBounds(100, 100, 450, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.btnClickPen = new JButton("Start");
        this.btnClickPen.addActionListener(this.penController);
        this.lblClickcount = new JLabel("Clickcount:");

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(this.btnClickPen, BorderLayout.CENTER);
        mainPanel.add(this.lblClickcount, BorderLayout.NORTH);

        this.getContentPane().add(mainPanel);
        this.setVisible(true);
    }

    @Override
    public void update() {
        if (this.penController.isFinish()) {
            this.btnClickPen.setEnabled(false);
            new ResultDialog(this.penController, this);
            this.setEnabled(false);
            this.setVisible(false);
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
    public void windowStateChanged(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSED) {
            this.startMenu.getFocus();
        }
    }

}
