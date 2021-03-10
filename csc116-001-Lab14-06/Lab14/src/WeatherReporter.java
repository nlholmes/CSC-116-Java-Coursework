import java.util.*;
import java.io.*;

/**
 * Program to get input from weather text file and process
 * 
 * @author Suzanne Balik
 * @author Jessica Young Schmidt
 * @author Nathan Holmes and Alexis Voulgaropoulos
 */
public class WeatherReporter {
    
    /**
     * Start of year index in date
     */
    public static final int YEAR_START = 0;
    
    /**
     * End of year index in date
     */
    public static final int YEAR_END = 4;
    
    /**
     * Start of month index in date
     */
    public static final int MONTH_START = 4;
    
    /**
     * End of month index in date
     */
    public static final int MONTH_END = 6;
    
    /**
     * Start of day index in date
     */
    public static final int DAY_START = 6;
    
    /**
     * Starts program
     * 
     * @param args command arguments
     */
    public static void main(String[] args) {
        userInterface();
    }

    /**
     * Deals with all interactions with the user
     */
    public static void userInterface() {
        
        // sets up scanners
        Scanner console = new Scanner(System.in);
        Scanner fileScanner = getInput(console);
        
        
        // Processes lines from file
        fileScanner.nextLine(); // skips header line
        while (fileScanner.hasNextLine()) {
            System.out.println(processLine(fileScanner.nextLine()));
        }
    }

    /**
     * Processes a line of the text file (String) in order to print the correct
     * output to the console
     * 
     * @param line the line to be processed
     * @return processed line
     */
    public static String processLine(String line) {
        
        Scanner lineScanner = new Scanner(line);
        
        // scans in all needed
        String date = "";
        double high = 0;
        double low = 0;
        String truth = "";
        while(lineScanner.hasNext()) {
            date = lineScanner.next();
            lineScanner.next(); // skip average
            high = lineScanner.nextDouble();
            low = lineScanner.nextDouble();
            truth = lineScanner.next();
        }
        // extracting mm/dd/yyyy from date
        String year = date.substring(YEAR_START,YEAR_END);
        String month = date.substring(MONTH_START,MONTH_END);
        String day = date.substring(DAY_START);
        
        // extracting if it was snowing
        String rain = "";
        String snow = "";
        
        if(truth.charAt(2) == '1') {
            snow = "yes";
        } else {
            snow = "no";
        }
        // extracting if it was raining
        if(truth.charAt(1) == '1') {
            rain = "yes";
        } else {
            rain = "no";
        }
        

        // NOTE: String.format can be used similar to System.out.printf
        return String.format("%2s/%2s/%4s Low:%6.1f High:%6.1f Rain:%4s Snow:%4s",
                month, day, year, low, high, rain, snow);
    }

    /**
     * Prompt the user for a legal file name, create and return a Scanner tied to
     * the file
     * 
     * @param console console for user input
     * @return Scanner tied to the input file
     */
    public static Scanner getInput(Scanner console) {
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
