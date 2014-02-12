package de.julmas.projects.penclicking;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Pen pen = new Pen(0);
    	pen.click();
        System.out.println( pen.toString() );
    }
}
