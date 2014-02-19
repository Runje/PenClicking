package de.julmas.projects.penclicking;

import de.julmas.projects.penclicking.controller.PenController;
import de.julmas.projects.penclicking.view.StartMenu;

/**
 * Class with main method for startup.
 * @author jmayer
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
        StartMenu startMenu = new StartMenu(penController);
        startMenu.setVisible(true);
    }

}
