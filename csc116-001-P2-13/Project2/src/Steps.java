import java.util.*;
import java.awt.*;
import java.lang.Math;


/**
 * Draws steps on drawing panel based off inputs from the user
 * @author Nathan Holmes
 */
public class Steps {
    
    /**
     * Pixels for panel width dimension, 740 for this
     */
    public static final int PANEL_WIDTH = 740;
    
    /**
     * Pixels for panel hieght dimension
     */
    public static final int PANEL_HEIGHT = 420; 
    
    /**
     * Pixels for step width
     */
    public static final int STEP_WIDTH = 80;
    
    /**
     * Pixels for step initial height and height increment
     */
    public static final int STEP_HEIGHT = 40;
    
    /**
     * Pixels representing max bound of RGB inputs
     */
    public static final int MAX_RGB = 255;
    
    /**
     * Maximum steps allowed (for Project 2 this number comes out to be 8)
     */
    public static final int MAX_STEPS = 8;
    
    /**
     * X coordinate for top stairs
     */
    public static final int X_TOP = 5;
    
    /**
     * Y coordinate for top stairs
     */
    public static final int Y_TOP = 5;
    
    /**
     * X coordinate for bottom stairs
     */
    public static final int X_BOT = 735;
    
    /**
     * Y coordinate for bottom stairs
     */
    public static final int Y_BOT = 415;
    
    
    
    /**
     * Starts the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        /**
         * Getting inputs
         */
        Scanner console = new Scanner(System.in);
        
        System.out.print("Number of steps (1-8): ");
        int stepNum = stepFix(console.nextInt());
        
        System.out.print("Red value (0-255): ");
        int red = rgbFix(console.nextInt());
        
        System.out.print("Green value (0-255): ");
        int green = rgbFix(console.nextInt());
        
        System.out.print("Blue value (0-255): ");
        int blue = rgbFix(console.nextInt());
        
        System.out.println("\n*CLOSE the Drawing Panel to exit the program*");
        
        /**
         * Creating colors
         */
        Color rgb = new Color(red, green, blue);
        Color rgbInverse = new Color(MAX_RGB - red, MAX_RGB - green, MAX_RGB - blue);
        
        /**
         * Drawing the steps
         */
        DrawingPanel panel = new DrawingPanel(PANEL_WIDTH, PANEL_HEIGHT);
        panel.setBackground(rgbInverse);
        
        Graphics g = panel.getGraphics();
        
        drawTopSteps(g, rgb, stepNum, X_TOP, Y_TOP, STEP_WIDTH, STEP_HEIGHT);
        drawBottomSteps(g, rgb, stepNum, X_BOT, Y_BOT, STEP_WIDTH, STEP_HEIGHT);

        console.close();
    }
    
    /**
     * Sets invalid RGB input < 0 to 0 and input > 255 to 255
     * @param val console RGB input value
     * @return accepted/corrected RGB value
     */
    public static int rgbFix(int val) {
        return Math.min(Math.max(val, 0), MAX_RGB);
    }
    
    /**
     * Sets invalid step input < 0 to 1 and input > 8 to 8
     * @param step console step number input
     * @return accepted/corrected step value
     */
    public static int stepFix(int step) {
        return Math.min(Math.max(step,1), MAX_STEPS);
    }
    
    /** 
     * Draws the given number of (upside down) steps with the 
     * given color such that the upper-lefthand corner of the steps is at point (x,y)
     * All steps have the given width; the first step has the given height, the second
     * step has twice the given height, etc.
     *
     * Skeleton copied from class website
     * @param g graphics object
     * @param color rgb color value
     * @param numberOfSteps number of steps to create
     * @param x horizontal position for corner of steps
     * @param y vertical position for corner of steps
     * @param width horizontal dimension of each step
     * @param height vertical dimension of each step
     */
    public static void drawBottomSteps(Graphics g, Color color, int numberOfSteps,
                                  int x, int y, int width, int height) {
        int currentHeight = height * numberOfSteps;
        int panHeight = y;
        int panWidth = x;
        g.setColor(color);
        
        for(int i = 0; i < numberOfSteps; i++) {
            x = panWidth - width * (i + 1); //based off of coords
            y = panHeight - currentHeight;
            
            
            g.fillRect(x, y, width, height * (numberOfSteps - i));
            
            currentHeight -= height;   
        }
    }
    
    /**
     * Draws the given number of steps with the given color such that the
     * lower-righthand corner of the steps is at point (x,y)
     * All steps have the given width; the first step has the given height, the second
     * step has twice the given height, etc.
     *
     * Skeleton copied from class website
     * @param g graphics object
     * @param color rgb color value
     * @param numberOfSteps number of steps to create
     * @param x horizontal position for corner of steps
     * @param y vertical position for corner of steps
     * @param width horizontal dimension of each step
     * @param height vertical dimension of each step
     */
    public static void drawTopSteps(Graphics g, Color color, int numberOfSteps,
                                     int x, int y, int width, int height) {
        int currentHeight = height * numberOfSteps;
        g.setColor(color);
        for(int i = 0; i < numberOfSteps; i++) {
            g.fillRect(x, y, width, currentHeight);
            x += width;
            currentHeight -= height;
        }
    }
}