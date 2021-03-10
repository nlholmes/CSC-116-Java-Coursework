/**
 * Program will calculate GPA weight for a specfic class grade
 * Using method grades
 *
 * @author Andrew Sauerbrei, Nathan Holmes
 */

public class Grades {
    /**
     * Starts program and calls method grades
     *
     * @param args command line arguments
     */
    public static void main (String[] args){
        double yourGrade = grade(79);
        System.out.println(yourGrade);
    }

    /**
     * Method that computes GPA grade based on course grade parameter
     * gets bigger val of grade and 60
     * subtracts 60 from effective grade and multiplies by 0.1 for GPA
     *
     * @param courseGrade grade to be used for GPA calculation
     * @return calculated GPA 
     */
    public static double grade (int courseGrade){
        double effGrade = Math.max(courseGrade, 60);
        return (effGrade - 60) * 0.1;
    }
}
