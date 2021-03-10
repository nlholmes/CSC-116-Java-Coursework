

import java.util.Scanner;
/**
 * Returns input name (FIRST LAST) to reverse format (LAST, FIRST)
 * @author Nathan Holmes
 */
public class ReverseNames {
    /**
     * Starts the program
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Note that if user doesn't follow instructions, we cannot guarantee
        // the correct output.

        Scanner in = new Scanner(System.in);
        
        
        System.out.println("Your name in reverse order is: " + getReverse(in));
    }
    
    // Method should prompt user for name then return string with the name reversed
    /**
     * Method to reverse the input name
     * @param console input format from user
     * @return name in reverse format
     */
    public static String getReverse(Scanner console) {
        System.out.print("Please enter your full name: ");
        String name = console.nextLine();
        
        int spaceDex = name.indexOf(" ");
        String first = name.substring(0, spaceDex);
        String last = name.substring(spaceDex);
        
        
        return last + ", " + first;
    }
}
