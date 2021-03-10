import java.io.*;
import java.util.*;
/**
 * Compresses or decompresses input file, assumes all text is lowercase
 * @author Nathan Holmes
 */
 
public class Compression {
    /**
     * Starts the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
    
        // Header
        System.out.println();
        System.out.println("This is the Compression Program");
        System.out.println("Enter C for Compression, D for Decompression, or Q to Quit");
        System.out.println("Then input the file path of the file to be compressd or decompressed");
        System.out.print("Finally input the file path of the file to");
        System.out.println("contain the compressd or decompressed text");
        System.out.println();
        
        Scanner console = new Scanner(System.in);
        boolean compOrDecomp = getCompOrDecomp(console); 
        Scanner inputFile = getInputScanner(console);
        PrintStream outputFile = getOutputPrintStream(console);
        
        processFile(compOrDecomp, inputFile, outputFile);
    }
    
    
    //Repeatedly prompts the user for the name of an input file until the user enters
    //the name of an existing file; then creates and returns a Scanner for the input file.
    //See the lecture notes for your section and/or the textbook for examples.
    //Use a try/catch block to catch and handle any FileNotFoundException's that occur
    /**
     * Gets input from console for file
     * @param console input from user
     * @return scanner of input
     * 
     * Boilerplate code from class website
     */
    public static Scanner getInputScanner(Scanner console){
        Scanner input = null;
        while (input == null) {
            System.out.print("input file name? ");
            String name = console.nextLine();
            //System.out.println(name);
            try {
                input = new Scanner(new File(name));
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please try again.");
            }
        }
        return input;
    }
    
    //Prompts the user for the name of an output file. 
    //If the file does not exist, creates and returns a PrintStream for the output file.
    //If the file does exist, prints an error message and returns null OR
    //does one of the Extra Credit options described below.
    //Use a try/catch block to catch and handle any FileNotFoundException's that occur and
    //return null
    /**
     * Gets printstream output
     * @param console input from user
     * @return PrintStream of input
     *
     * Boilerplate code from class website was modified for extra credit
     */
    public static PrintStream getOutputPrintStream(Scanner console){
        PrintStream outputFile = null;
        File fileName = null; // initialize fileName as well
        while (outputFile == null) {
            boolean reprompt = false;
            do {
                System.out.print("output file name? ");
                String name = console.nextLine();
                fileName = new File(name);
                
                // Extra credit
                
                if(fileName.exists() == true) { // if file exists
                    System.out.println();
                    System.out.print(name + " already exists, okay to overwrite? (y or n): ");
                    String yesNo = console.nextLine();
                    
                    if(yesNo.toLowerCase().equals("y") == true) { // if  okay to overwrite, continue
                    // (need to make repromt false again incase they input 
                    // the same file but change their mind)
                        reprompt = false;
                    } else { // if not okay to overwrite, reprompt for file name
                        System.out.print("New "); // appends to next print statement on console
                        reprompt = true;
                    } 
                    
                } // if file does not exist, continue (no need to put anything)
                //System.out.println(reprompt);
            } while (reprompt == true);
            
            
            try {
                outputFile = new PrintStream(fileName);
            } catch (FileNotFoundException e) {
                System.out.println("File unable to be written. Please try again.");
            }
        }
        return outputFile;
    }
    
    /**
     * Returns the compression or decompression boolean value
     * @param console input from user
     * @return compOrDecomp boolean determining if want compression (true) or decompression (false)
     */
    public static boolean getCompOrDecomp(Scanner console) {
        String choice = "";
        boolean compOrDecomp = true;
        
        while(!choice.equals("c") && !choice.equals("d")) {
            System.out.print("Compress (c), Decompress (d), or Quit (q): ");
            // switched from console.next() to console.nextLine() to solve interaction 
            // problem with getInput and getOutput methods
            choice = console.nextLine().toLowerCase(); 
            if(choice.equals("c")) {
                compOrDecomp = true;        // choice to compress file
            } else if(choice.equals("d")) {
                compOrDecomp = false;       // choice to decompress file
            } else if(choice.equals("q")) {
                System.exit(1);
            } else {
                System.out.println("Invalid Action");
            }
        }
        
        return compOrDecomp;
    }
    
    
    //If compress is true, compresses text in input and outputs compressed text
    //If compress is false, decompresses text in input and outputs decompressed text
    /**
     * Processes file
     * @param compress if true compresses text, if false decompresses text
     * @param input file to get text from
     * @param output file new text is printed to
     */
    public static void processFile (boolean compress, Scanner input, PrintStream output){
        // think this is more efficient (2n + 3)
        if(compress == true) { // compress
            while(input.hasNextLine()) {
                //String a = input.nextLine();
                //System.out.println(a);
                //String compLine = compressLine(a);
                //output.println("a");
                String compLine = compressLine(input.nextLine());
                //System.out.println(compLine);
                output.println(compLine);
                //output.println("b");
            }
        } else { // decompress
            while(input.hasNextLine()) {
                String decLine = decompressLine(input.nextLine());
                output.println(decLine);
            }
        }
    }    
    
    //Returns string containing compressed line
    /**
     * Compresses line
     * @param line line to compress
     * @return compressed line
     */
    public static String compressLine(String line){
        //System.out.println(line);
        //System.out.println();
        Scanner lineScanner = new Scanner(line);
        String compLine = "";
        while(lineScanner.hasNext()) {
            compLine += compressWord(lineScanner.next());
            
            if(lineScanner.hasNext()) {
                compLine += " ";
            }
        }
        //System.out.println(compLine);
        return compLine;
    }
    
    //Returns string containing compressed word (token)
    /**
     * Compresses a word
     * @param word token to compress
     * @return compressed word
     */
    public static String compressWord(String word) {
        // I wish for arrays
        
        // I got arrays
        String[] part = {"the", "an", "ion", "ing", "tis", "men", "re"};
        String[] symbol = {"&", "~", "#", "@", "%", "+", "$"};
        int dex;
        for(int i = 0; i < part.length; i++) {
            dex = word.indexOf(part[i]);
            if(dex > -1) {
                word = word.substring(0, dex) + symbol[i] + word.substring(dex + part[i].length());
            }
        }
        
        
        return word; // now compressed
    }
    
    //Returns string containing decompressed line
    /**
     * Decompresses whole line
     * @param line line to decompress
     * @return decompressed line
     */
    public static String decompressLine(String line){
        Scanner lineScanner = new Scanner(line);
        
        String decLine = "";
        while(lineScanner.hasNext()) {
            decLine += decompressWord(lineScanner.next());
            if(lineScanner.hasNext()) {
                decLine += " ";
            }
        }
        return decLine;
    }
    
    //Returns string containing decompressed word (token)
    /**
     * Decompresses a word
     * @param word token to decompress
     * @return decompressd word
     */
    public static String decompressWord(String word) {
        // same as compressWord but reversed
        
        String[] part = {"the", "an", "ion", "ing", "tis", "men", "re"};
        String[] symbol = {"&", "~", "#", "@", "%", "+", "$"};
        int dex;
        for(int i = 0; i < symbol.length; i++) {
            //int[] dex = word.indexOf(symbol[i]);
            dex = word.indexOf(symbol[i]);
            if(dex > -1) {
                word = word.substring(0, dex) + part[i] + word.substring(dex + symbol[i].length()); 
            }
        }
        
        
        return word;
    }
    
    
}
