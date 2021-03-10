/**
 * Tests BACCalculator program
 * @author Suzanne Balik
 */
public class BACCalculatorTest {
    /**
     * Tests BACCalculator program
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        double bac = BACCalculator.calculateBAC(BACCalculator.WOMAN_CONSTANT, 100, 5, 2);
        System.out.println("Expected: 0.1555 Actual: " + bac);
        bac = BACCalculator.calculateBAC(BACCalculator.MAN_CONSTANT, 150, 3, 1);
        System.out.println("Expected: 0.074 Actual: " + bac);
        bac = BACCalculator.calculateBAC(BACCalculator.MAN_CONSTANT, 200, 3, 5);
        System.out.println("Expected: 0.0 Actual: " + bac);
    }
}