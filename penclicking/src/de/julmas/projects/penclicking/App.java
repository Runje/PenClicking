package de.julmas.projects.penclicking;

import de.julmas.projects.penclicking.controller.PenController;
import de.julmas.projects.penclicking.view.GUI;

/**
 * Hello world!
 * 
 */
public class App {
    private App() {
        
    }
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        PenController penController = new PenController();
        GUI window = new GUI( penController );
        window.setVisible(true);
    }

}
