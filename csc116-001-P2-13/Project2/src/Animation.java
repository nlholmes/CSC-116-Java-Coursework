import java.awt.*;
import java.util.*;

/**
 * Animates a rocket, uses code taken from class website
 * @author Nathan Holmes
 */

public class Animation {
    
    /**
     * width of panel
     */
    public static final int WIDTH = 500;
    
    /**
     * height of panel
     */
    public static final int HEIGHT = 400;
    
    /**
     * pause time between drawings
     */
    public static final int SLEEP_TIME = 200;
    
    /**
     * Starting x position for animated object placement
     */
    public static final int INITIAL_X = 220;
    
    /**
     * starting y position for animated object
     */
    public static final int INITIAL_Y = 250;
    
    /**
     * number of times to update animation (frames)
     */
    public static final int NUMBER_OF_UPDATES = 85;
    
    /**
     * Change in y direction of the animated object
     */
    public static final int DY = 5;
    
    /**
     * Creates the animation by repeatedly drawing the background 
     * and figure, then "sleeping" (pausing) for a short time.
     * @param args command line arguments
     */
    public static void main (String[] args) {
        
        DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
        Graphics g = panel.getGraphics();
        
        int x = INITIAL_X;
        int y = INITIAL_Y;
        for (int i = 0; i < NUMBER_OF_UPDATES; i++) {
            drawBackground(g);
            drawRocket(g, x, y - DY * i);
            
            if (i % 2 == 0) {
                drawRedFlames1(g, x, y - DY * i);
                drawRedFlames2(g, x - 15, y - DY * i);
            } else {
                drawRedFlames2(g, x, y - DY *i);
                drawRedFlames1(g, x + 15, y - DY * i);
            }
            
            panel.sleep(SLEEP_TIME);
        } 
         
        System.out.println("\n*CLOSE the Drawing Panel to exit the program*");
    }
    
    /**
     * Draws background of space with stars
     * @param g graphics object
     */
    public static void drawBackground(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH,HEIGHT);
        
        g.setColor(Color.YELLOW);
        g.fillOval(40, 100, 10, 10);
        g.fillOval(330, 250, 5, 5);
        g.fillOval(20, 300, 8, 8);
        g.fillOval(150, 170, 15, 15);
        g.fillOval(190, 130, 3, 3);
        g.fillOval(10, 480, 20, 20);
        g.fillOval(400, 400, 4, 4);
        g.fillOval(405, 50, 13, 13);
        g.fillOval(430, 365, 9, 9);
        g.fillOval(110, 305, 29, 29);
        g.fillOval(370, 145, 6, 6);
        g.fillOval(250, 290, 11, 11);
        g.fillOval(120, 25, 13, 13);
        g.fillOval(260, 70, 23, 23);
    }
    
    /**
     * Draws rocket cone, body, and flame base
     * @param g graphics object
     * @param x horizontal position
     * @param y vertical position
     */
    public static void drawRocket(Graphics g, int x, int y) {
        /**
         * Created in order: 
         * 60x120 Rectangular body 
         * 60x60 Triangular cone 
         * (60-70)x20 Trapezoidal exhaust
         */
        g.setColor(Color.GRAY);
        g.fillRect(x, y, 60, 120);
        
        g.setColor(Color.LIGHT_GRAY);
        Polygon cone = new Polygon();
        cone.addPoint(x, y);
        cone.addPoint(x + 30, y - 60);
        cone.addPoint(x + 60, y);
        g.fillPolygon(cone);
        
        g.setColor(Color.ORANGE);
        Polygon flame = new Polygon();
        flame.addPoint(x, y + 120);
        flame.addPoint(x - 10, y + 140);
        flame.addPoint(x + 70, y + 140);
        flame.addPoint(x + 60, y + 120);
        
        g.fillPolygon(flame);
    }
    

    
    /**
     * Draws red flame triangle 1
     * @param g graphics object
     * @param x horizontal position
     * @param y vertical position
     */
    public static void drawRedFlames1(Graphics g, int x, int y) {
        g.setColor(Color.RED);
        Polygon redFlames1 = new Polygon();
        redFlames1.addPoint(x + 5, y + 120);
        redFlames1.addPoint(x + 15, y + 120);
        redFlames1.addPoint(x + 10, y + 155);
        
        g.fillPolygon(redFlames1);
    }
    
    /**
     * Draws red flame triangle 2
     * @param g graphics object
     * @param x horizontal position
     * @param y vertical position
     */
    public static void drawRedFlames2(Graphics g, int x, int y) {
        g.setColor(Color.RED);
        Polygon redFlames2 = new Polygon();
        redFlames2.addPoint(x + 40, y + 120);
        redFlames2.addPoint(x + 50, y + 120);
        redFlames2.addPoint(x + 45, y + 155);
        
        g.fillPolygon(redFlames2);
    }
    
}
