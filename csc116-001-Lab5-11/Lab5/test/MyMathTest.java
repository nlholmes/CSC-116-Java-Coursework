/**
 * Tests methods that calculate min, max, and average of three values
 * 
 * @author Jessica Young Schmidt
 */
public class MyMathTest {

    /** Format used for printf */
    public static final String FORMAT = "%-35s%10.3f%10.3f\n";

    /**
     * The method that is executed when the program is run
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Method Call                          Expected    Actual");
        System.out.println("-------------------------------------------------------");

        System.out.printf(FORMAT, "min(5, 6, 7)", 5.0, MyMath.min(5, 6, 7));

        System.out.printf(FORMAT, "min(20, 25, 15)", 15.0, MyMath.min(20, 25, 15));

        System.out.printf(FORMAT, "min(77.7, 11.1, 33.3)", 11.1, MyMath.min(77.7, 11.1, 33.3));

        System.out.printf(FORMAT, "max(5, 6, 7)", 7.0, MyMath.max(5, 6, 7));

        System.out.printf(FORMAT, "max(20, 25, 15)", 25.0, MyMath.max(20, 25, 15));

        System.out.printf(FORMAT, "max(77.7, 11.1, 33.3)", 77.7, MyMath.max(77.7, 11.1, 33.3));

        System.out.printf(FORMAT, "min(77.7, 11.1, 33.3)", 11.1, MyMath.min(77.7, 11.1, 33.3));

        System.out.printf(FORMAT, "average(1, 2, 3)", 2.0, MyMath.average(1, 2, 3));

        System.out.printf(FORMAT, "average(100.0, 98.8, 77.3)", 92.0333333333333,
                MyMath.average(100.0, 98.8, 77.3));

        System.out.printf(FORMAT, "average(-9, 3, 9)", 1.0, MyMath.average(-9, 3, 9));
    }

}
