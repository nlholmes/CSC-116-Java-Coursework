
import java.util.Scanner;

/**
 * Calculates the original and divided numbers of coconuts from the puzzle
 * @author Nathan Holmes
 */
 
public class Coconuts {
    /**
     * Starts the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter a value for a: ");
        int a = console.nextInt();
        printResults(a);
    }
    
    /**
     * Calculates numbers of coconuts from input value of a
     * @param a input integer value for a in the formula: number of coconuts = 12495 + 15625 * a
     */
    public static void printResults(int a) {
        int total = 12495 + 15625 * a;
        System.out.println("The initial number of coconuts is " + total + ".");
        
        int newTotal = total;
        for(int i = 1; i <= 5; i++) {
            
            int sailorFifth = newTotal / 5;
            newTotal -= sailorFifth;
            newTotal--;
            
            System.out.print("Sailor " + i + ": ");
            System.out.println(sailorFifth + " coconuts; Monkey: 1 coconut.");
        }
        
        System.out.print(newTotal + " coconuts remain, each sailor gets ");
        System.out.println(newTotal / 5 + " and 1 for the monkey.");
        
    }

}    