/** Our Math class provides methods that return the min and max of three values
 *
 * @author Nathan Holmes, Andrew Sauerbrei
 */

public class MyMath {
    /**
     * Starts the program.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println(min(0, 1, 10)); // EXPECTED OUTPUT: 0.0
        System.out.println(max(0, 1, 10)); // EXPECTED OUTPUT: 10.0
        System.out.println(average(0, 1, 10)); // EXPECTED OUTPUT: 3.6666666666666665
    }

    /**
     * Returns the smallest parameter
     * 
     * @param a first double in comparison
     * @param b second double in comparison
     * @param c third double in comparison
     * @return minimum of a, b, c
     */
    public static double min(double a, double b, double c) {
        /**
         * Gets the min of two numbers and then compares it to the third for the true min
         */
        return Math.min(Math.min(a,b),c);
    }

    /**
     * Returns the largest parameter
     * 
     * @param a first double in comparison
     * @param b second double in comparison
     * @param c third double in comparison
     * @return maximum of a, b, c
     */

    public static double max(double a, double b, double c) {
        /**
         * Gets the max of two numbers and then compares it to the third for the true max
         */
        return Math.max(Math.max(a,b),c);
    }

    /**
     * Returns the average of the three parameters
     * 
     * @param a first double in average
     * @param b second double in average
     * @param c third double in average
     * @return average of a, b, c
     */

    public static double average(double a, double b, double c) {
        /**
         * Takes three input values, sums them, and divides by three.
         */

        return (a + b + c) / 3;
    }
}
