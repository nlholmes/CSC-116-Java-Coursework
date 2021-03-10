import java.io.*;
import java.util.*;

/**
 * Flips the order of pairs of lines
 * 
 * @author Jessica Young Schmidt
 * @author Nathan Holmes and Alexis Voulgaropoulos
 */
public class FlipLines {

    /**
     * Starts the program
     * 
     * @param args array of command line arguments
     */
    public static void main(String[] args) {
        userInterface();
    }

    /**
     * Interface with the user
     */
    public static void userInterface() {
        Scanner console = new Scanner(System.in);
        Scanner fileScanner = getInputScanner(console);
        System.out.println(flipLines(fileScanner));
    }

    /**
     * Flips the order of pairs of lines in input. If the file contains an odd
     * number of lines, leave the last line unmodified.
     * 
     * @param input Scanner for the input file
     * @return String of input with lines flipped
     */
    public static String flipLines(Scanner input) {
        String flipped = "";
        String next = "";
        while(input.hasNextLine()) {
            String line = input.nextLine() + "\n";
            if(input.hasNextLine()) {
                next = input.nextLine() + "\n";
                flipped = flipped + next + line; 
            } else { // if last line
                next = "";
                flipped += line;
            }
        }
        return flipped;
    }

    /**
     * Reads filename from user until the file exists, then return a file scanner
     * 
     * @param console Scanner that reads from the console
     * 
     * @return a scanner to read input from the file
     */
    public static Scanner getInputScanner(Scanner console) {
        System.out.print("Enter a file name to process: ");
        File file = new File(console.next());
        while (!file.exists()) {
            System.out.print("File doesn't exist. " + "Enter a file name to process: ");
            file = new File(console.next());
        }
        Scanner fileScanner = null;// null signifies NO object reference
                                   // while (result == null) {
        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found. ");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return fileScanner;
    }

}
