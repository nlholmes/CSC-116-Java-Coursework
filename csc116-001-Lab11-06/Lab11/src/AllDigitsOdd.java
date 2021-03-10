import java.util.*; 
/**
 * Tests if all digits of input are odd
 * @author Nathan Holmes, Alexis Voulgaropoulos
 */

public class AllDigitsOdd {
    /**
     * Starts the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        
        
        while(!console.hasNextInt()) {
            console.next();
            System.out.println("Not an int, try again");
            System.out.print("Enter an integer: ");
        }
        
        int number = console.nextInt();
        areAllDigitsOdd(number);
    }
    /**
     * Gets last digit of number
     * @param num number to get last digit of
     * @return absolute value of unput modulus 10
     */
    public static int lastDigit(int num) {
        return Math.abs(num % 10);
    }
    /**
     * Removes last digit from input number
     * @param num number to remove last digit of
     * @return absolute value of input divided by 10
     */
    public static int withoutLastDigit(int num) {
        return Math.abs(num / 10);
    }
    
    /**
     * Determines if all input digits are odd
     * @param num number to check if all digits are odd
     * @return boolean value, true if all digits are odd
     */
    public static boolean areAllDigitsOdd(int num) {
        if (num == 0) {
            System.out.println("false");
            return false;
        } else {
            while (Math.abs(num) > 0){
                if(lastDigit(num) % 2 == 0) {
                    System.out.println("false");
                    return false;
                }
                num = withoutLastDigit(num);
            }
        }
        
        System.out.println("true");
        return true;
    }
}
