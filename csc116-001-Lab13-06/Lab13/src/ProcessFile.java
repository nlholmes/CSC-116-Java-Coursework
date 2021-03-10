import java.util.*;
import java.io.*;

/**
 * Program reads in a file and find the max, min, sum, count, and average of all
 * integers in the file
 * 
 * @author Dr. Sarah Heckman (sarah_heckman@ncsu.edu)
 * @author Dr. Jessica Young Schmidt
 * @author Nathan Holmes and Alexis Voulgaropoulos
 */
public class ProcessFile {

    /**
     * Starts the program
     * 
     * @param args array of command line arguments
     * @throws FileNotFoundException if file cannot be found
     */
    public static void main(String[] args) throws FileNotFoundException {
        userInterface();
    }

    /**
     * Interface with the user
     * 
     * @throws FileNotFoundException if file cannot be found
     */
    public static void userInterface() throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        Scanner fileScanner = getInputScanner(console);
        System.out.println(processFile(fileScanner));
        console.close();
        fileScanner.close();
    }

    /**
     * Processing the file
     * 
     * @param fileScanner Scanner for file
     * @return String that contains the stats
     */
    public static String processFile(Scanner fileScanner) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE; // min = integer.max (max val for integer)
        int sum = 0;
        int count = 0;
        double average;
        
        while(fileScanner.hasNext()) {
            if(fileScanner.hasNextInt()) {
                int integer = fileScanner.nextInt();
                sum += integer;
                count += 1;
                
                max = Math.max(integer, max);
                min = Math.min(integer, min);
            } else {
                fileScanner.next();
            }
        }
        average = (1.0 * sum) / count;
        // Only print if count is positive
        if (count > 0) {
            return "Maximum = " + max + "\nMinimum = " + min + "\nSum = " + sum + "\nCount = "
                    + count + "\nAverage = " + average;
        } else {
            return "No integers in file.";
        }
    }

    /**
     * Reads filename from user until the file exists, then return a file scanner
     * 
     * @param console Scanner that reads from the console
     * @return a scanner to read input from the file
     * @throws FileNotFoundException if file cannot be found
     */
    public static Scanner getInputScanner(Scanner console) throws FileNotFoundException {
        System.out.print("Enter a file name to process: ");
        //File file = new File("test-files/" + console.next());
        File file = new File(console.next()); // path wanted to be entered by user
        while (!file.exists()) {
            System.out.print("File doesn't exist. Enter a file name to process: ");
            //file = new File("test-files/" + console.next());
            file = new File(console.next());
        }

        Scanner fileScanner = new Scanner(file);
        return fileScanner;
    }
}
