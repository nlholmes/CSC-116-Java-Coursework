/**
 * Tests methods that calculate min, max, and average of three values
 * 
 * @author Jessica Young Schmidt
 */
public class GradesTest {

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

        System.out.printf(FORMAT, "grade(0)", 0.0, Grades.grade(0));
        System.out.printf(FORMAT, "grade(45)", 0.0, Grades.grade(45));
        System.out.printf(FORMAT, "grade(60)", 0.0, Grades.grade(60));
        System.out.printf(FORMAT, "grade(63)", 0.3, Grades.grade(63));
        System.out.printf(FORMAT, "grade(80)", 2.0, Grades.grade(80));
        System.out.printf(FORMAT, "grade(90)", 3.0, Grades.grade(90));
        System.out.printf(FORMAT, "grade(95)", 3.5, Grades.grade(95));
        System.out.printf(FORMAT, "grade(100)", 4.0, Grades.grade(100));

    }

}
