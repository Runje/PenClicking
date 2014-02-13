package de.julmas.projects.penclicking;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	public JFrame frame;
	private Pen pen;
	private JLabel lblClickcount;

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnClickPen = new JButton("Click pen");
		btnClickPen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ( pen == null  )
				{
					pen = new Pen( 10 * 1000);
				} else
				{
					pen.click();
					lblClickcount.setText( "Clickcount: " + pen.clicks );
					
				}
				System.out.println("Pen clicked");
			}
		});
		frame.getContentPane().add(btnClickPen, BorderLayout.CENTER);
		
		lblClickcount = new JLabel("Clickcount:");
		frame.getContentPane().add(lblClickcount, BorderLayout.NORTH);
	}

}
