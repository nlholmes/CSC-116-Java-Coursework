import java.io.*;
import java.util.*;
/**
 * Reads input file and prints the input file text to the output file 
 * with only one space between each token
 * @author Josh Carter and Nathan Holmes and Alexis Voulgaropoulos
 */
public class Collapse {

    /**
     * Starts the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Scanner input = getInputScanner(console);
        PrintStream output = getOutputPrintStream(console);
        // Use input and output
        output = collapseSpaces(input, output);
        
        input.close();
        output.close();
        console.close();
    }

    /**
     * Returns a Scanner for input from a file.
     * @param console Scanner for console
     * @return Scanner for input from a file
     */
    public static Scanner getInputScanner(Scanner console) {
        Scanner input = null;
        while (input == null) {
            System.out.print("input file name? ");
            String name = console.nextLine();
            try {
                input = new Scanner(new File(name));
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please try again.");
            }
        }
        return input;
    }
    
    /**
     * Creates the printstream for the output file
     * @param console output file location
     * @return output file printstream
     */
    public static PrintStream getOutputPrintStream(Scanner console) {
        PrintStream outputFile = null;
        while (outputFile == null) {
            System.out.print("output file name? ");
            String name = console.nextLine();
            try {
                outputFile = new PrintStream(new File(name));
            } catch (FileNotFoundException e) {
                System.out.println("File unable to be written. Please try again.");
            }
        }
        return outputFile;
    }
    
    /**
     * Collapses spaces of input file, prints the new text to output file, and returns output file
     * @param input file path of input file
     * @param output file path of output file
     * @return updated printstream file
     */
    public static PrintStream collapseSpaces(Scanner input, PrintStream output) {
        //PrintStream output = null;
        String newLine = "";
        String newFile = "";
        
        //File name = new File(input);
        
        while(input.hasNextLine()) {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            while(lineScan.hasNext()) {
                
                output.print(lineScan.next());
                
                if(lineScan.hasNext()) { // if it isn't the last token on the line
                    output.print(" ");
                } // last token on line should not have space after
                
                //String word = lineScan.next();           
                //newLine = newLine + " " + word;
                
            }
            //newFile = newLine + "\n";
            //output.print("\n"); // next line escape sequence isnt recognized for output.print?
            output.println();
        }
        
        /**try {
                output = new PrintStream(input);
        } catch (FileNotFoundException e) {
                System.out.println("File unable to be written. Please try again.");
        }*/
        
        //output.print(newFile);
        
        return output;
        
        //return output;
    }
}
