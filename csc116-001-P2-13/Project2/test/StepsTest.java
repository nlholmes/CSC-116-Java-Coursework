import java.awt.Color;
import java.awt.Graphics;

/**
 * Tests the drawTopSteps() and drawBottomSteps() methods
 * @author Jessica Schmidt
 * @author Suzanne Balik
 */
public class StepsTest {
    /**
     * Draws 5 small blue top steps and 3 large red bottom steps
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(400, 400);
        Graphics g = panel.getGraphics();
        Steps.drawTopSteps(g, Color.BLUE, 5, 200, 20, 30, 15 );
        Steps.drawBottomSteps(g, Color.RED, 3, 350, 350, 100, 50 );
        System.out.println("*CLOSE the Drawing Panel to exit the program*");
    }
}