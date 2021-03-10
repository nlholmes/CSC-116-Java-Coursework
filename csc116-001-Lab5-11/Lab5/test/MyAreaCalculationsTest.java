/**
 * Tests methods that calculate area for various shapes.
 * 
 * @author Jessica Young Schmidt
 */
public class MyAreaCalculationsTest {

    /** Format used for printf */
    public static final String FORMAT = "%-35s%10.5f%10.5f\n";

    /**
     * The method that is executed when the program is run
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Method Call                         Expected  Actual");
        System.out.println("-------------------------------------------------------");

        System.out.printf(FORMAT, "triangleArea(8, 5.2, 7.1)", 18.151176098258745,
                MyAreaCalculations.triangleArea(8, 5.2, 7.1));

        System.out.printf(FORMAT, "triangleArea(3.0, 4.0, 5)", 6.0,
                MyAreaCalculations.triangleArea(3.0, 4.0, 5));

        System.out.printf(FORMAT, "cylinderSurfaceArea(3.0, 4.5)", 141.3716694115407,
                MyAreaCalculations.cylinderSurfaceArea(3.0, 4.5));

        System.out.printf(FORMAT, "cylinderSurfaceArea(5, 5)", 314.1592653589793,
                MyAreaCalculations.cylinderSurfaceArea(5, 5));
    }

}
