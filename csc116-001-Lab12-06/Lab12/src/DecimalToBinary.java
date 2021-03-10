import java.util.*;

/**
 * Converts a decimal integer to binary.
 *
 * @author Alexis Voulgaropoulos and Nathan Holmes
 */
 
public class DecimalToBinary {

    /**
     * Starts the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
    
        Scanner console = new Scanner(System.in);
        
        /**
         * Old code for reference
        while(true) {
            System.out.print("Enter a number (-1 to quit): ");
            int in = console.nextInt();
            if(in < 0 && in!=-1) {
                throw new IllegalArgumentException("Input is negative");
            }     
            if(in == -1) {
                break;
            }
            System.out.println(convertToBinary(in));
        }
        */
        
        /**
         * This way includes the while loop in case of non-integer inputs
         */
        int in;
        do {
            System.out.print("Enter a number (-1 to quit): ");
            /**
             * In case the user enters a non-integer input first
             */
            while(!console.hasNextInt()) {
                console.next();
                System.out.println("Not a positive integer, try again");
                System.out.print("Enter a positive integer (-1 to quit): ");
            }
            
            in = console.nextInt();
            while(in < 0 && in != -1) {
                System.out.println("Not a positive integer");
                System.out.print("Enter a positive integer (-1 to quit): ");
                
                
                /**
                 * In case user inputs a character after entering a negative
                 */
                while(!console.hasNextInt()) {
                    console.next();
                    System.out.println("Not a positive integer, try again");
                    System.out.print("Enter a positive integer (-1 to quit): ");
                }
                
                in = console.nextInt();
            }
            if(in >= 0) {
                System.out.println(convertToBinary(in));
            } 
        } while (in != -1);
        
    }
    
    /**
     * Converts inputted number to binary.
     * @param num number that is converted to binary.
     * @return newRem returns the binary version of the inputted number.
     */
    public static String convertToBinary(int num) {
        String rem = "";
        String newRem = "";
        
        if(num < 0) {
            throw new IllegalArgumentException("Negative value: " + num);
        }    
        
        if (num != 0){
            while(num > 0){
                rem += num % 2;
                num = num / 2;
            }
        } else {
            newRem += 0;
        }
        
        int length = rem.length();
        for(int i = 1; i <= length; i++) {
            newRem += rem.charAt(length - i);
        }
        
        return newRem;
    }
    
 
}
