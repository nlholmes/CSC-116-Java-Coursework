/** Methods in class calculate area for various shapes.
 * @author Nathan Holmes, Andrew Sauerbrei
 */
public class MyAreaCalculations {

    /**
     * The method that is executed when the program is run
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println(triangleArea(1, 1, 1));// EXPECTED OUTPUT: 0.4330127018922193
        System.out.println(cylinderSurfaceArea(1, 1)); // EXPECTED OUTPUT: 12.566370614359172
    }

    /**
     * Returns the area of a triangle with given side lengths
     * 
     * @param sideA first side of triangle
     * @param sideB second side of triangle
     * @param sideC third side of triangle
     * @return area of triangle
     */
    public static double triangleArea(double sideA, double sideB, double sideC) {
        /**
         * Finds the area of a triangle using three side lengths, as the hypotenuse is not known
         */
        
        double p = (sideA + sideB + sideC) / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    /**
     * Returns the surface area of a cylinder with the given radius and height
     * 
     * @param radius radius of cylinder
     * @param height height of cylinder
     * @return surface area of cylinder with radius and height
     */
    public static double cylinderSurfaceArea(double radius, double height) {
        /**
         * Returns cylinder surface area given radius and height using the formula and Math.PI
         */

        return 2 * Math.PI * radius * (height + radius);
    }
}
