/**
 * Prints out the ASCII art design of a bottle
 * @author Nathan Holmes
 */
public class Art {
    /**
     * Class constant representing line number for slashesCone
     */
    public static final int LINES = 6;
    
    /**
     * Class constant representing initial spaces for slashesCone
     */
    public static final int SPACES = 9;
    
    /**
     * Decides the thickness of the water bottle by printing that many underscores
     */
    public static final int NUMBER = 21;
    
    /**
     * Decides size of cap by printing underscores
     */
    public static final int CAP_SIZE = 9;
     
    
    /**
     * Starts the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        cap(CAP_SIZE);
        slashesCone(LINES, SPACES);
        
        outRib(NUMBER);
        inRib(NUMBER - 2);
        outRib(NUMBER);
        wall(1,NUMBER);
         
        for(int i = 1; i <= 2; i++){
            wall(1,NUMBER);
            inRib(NUMBER - 2);
            wall(1,NUMBER);
            inRib(NUMBER - 2);
            wall(1,NUMBER);
        }
         
        wall(2,NUMBER);
        outRib(NUMBER);
        wall(1,NUMBER);
        outRib(NUMBER);
        wall(2,NUMBER);
         
        bottom();
    }
    
    /**
     * Prints out the topmost part of the design, the cap and neck
     * @param size number of underscores need to print
     */
    public static void cap(int size) {
        System.out.print("       ");
        printScore(size);
        System.out.println();
        System.out.println("      |_-_-_-_-_|");
        System.out.print("      ");
        wall(1,size);
        System.out.print("      ");
        inRib(size - 2);
        System.out.print("      ");
        outRib(size);
        System.out.println("      | M.K.'97 |");
    }
     
    /**
     * Prints a downward opening cone of slashes
     * @param lines number of lines to repeat
     * @param space initial number of spaces between slashes
     */
    public static void slashesCone(int lines, int space) {
        int preSpace = lines;
        for(int i = lines; i >= 1; i--) {
            for(int j = preSpace; j >= 1; j--) {
                System.out.print(" "); 
            }
            
            System.out.print("/");
            
            for(int k = 1; k <= space; k++) {
                System.out.print(" ");
            }
            System.out.println("\\");
            
            space += 2;
            preSpace--;
        }
    }
     
     /**
      * Creates one line of normal orientation parenthesis rib
      * @param outScore number of underscores to print
      */
    public static void outRib(int outScore) {
        System.out.print("(");
        printScore(outScore);
        System.out.println(")");
    }
     
     /**
      * Creates one line of inverted orientation parenthesis rib
      * @param inScore number of underscores to print
      */
    public static void inRib(int inScore) {
        System.out.print(" )");
        printScore(inScore);
        System.out.println("(");
    }
     
    /**
     * Creates reps lines of 'wall' sections which use vertical bars
     * @param reps number of times to print the line
     * @param score number of underscores
     */
    public static void wall(int reps, int score) {
        for(int i = 1; i <= reps; i++) {
            System.out.print("|");
            printScore(score);
            System.out.println("|");
        }
    }
    
    /**
     * Prints underscores
     * @param pScore number of underscores
     */
    public static void printScore(int pScore) {
        for(int i = 1; i <= pScore; i++) {
            System.out.print("_");
        }
    }
     
     /**
      * Creates the bottom piece of the art to finish off the design
      */
    public static void bottom() {
        altWall(NUMBER);
        altWall(NUMBER);
        System.out.println("\\_____________________/");
        System.out.println(" '-------------------'");
    }
    
    /**
     * Creates a 'wall' with spaces instead of underscores
     * @param slots number of spaces to print
     */
    public static void altWall(int slots) {
        System.out.print("|");
        for(int i = 1; i <= NUMBER; i++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }
}