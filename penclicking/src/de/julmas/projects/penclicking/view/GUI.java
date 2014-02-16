package de.julmas.projects.penclicking.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import de.julmas.projects.penclicking.controller.PenController;
import de.julmas.projects.penclicking.util.observer.IObserver;

public class GUI extends JFrame implements IObserver {

    /**
     * 
     */
    private static final long serialVersionUID = -8853165778158196157L;
    private JLabel lblClickcount;
    private PenController penController;

    /**
     * Create the application.
     */
    public GUI(PenController penController) {
        this.penController = penController;
        this.penController.addObserver(this);
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private final void initialize() {
        this.setBounds(100, 100, 450, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnClickPen = new JButton("Click pen");
        btnClickPen.addActionListener(this.penController);
        this.getContentPane().add(btnClickPen, BorderLayout.CENTER);

        lblClickcount = new JLabel("Clickcount:");
        this.getContentPane().add(lblClickcount, BorderLayout.NORTH);
    }

    @Override
    public void update() {
        lblClickcount.setText( "Clickcount: " + this.penController.getPen().getClicks() );
    }

}
