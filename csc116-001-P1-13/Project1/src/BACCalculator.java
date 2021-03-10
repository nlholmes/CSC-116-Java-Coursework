/**
 * Calculats blood alcohol content given weight, drinks, gender, and hours
 * @author Nathan Holmes
 */
 
public class BACCalculator {
    /**
     * The following class constants were taken from the class website
     */
    
    /**
     * Blood alcohol content constant
     */
    public static final double BAC_CONSTANT = 0.016;
    
    /**
     * Male gender constant
     */
    public static final double MAN_CONSTANT = 9.0;
    
    /**
     * Lowest weight value used in calculations for a man
     */
    public static final int MAN_MIN_WEIGHT = 140;
    
    /**
     * Highest weight value used in calculations for a man
     */
    public static final int MAN_MAX_WEIGHT = 180;
    
    /**
     * Female gender constant
     */
    public static final double WOMAN_CONSTANT = 7.5;
    
    /**
     * Lowest weight value used in calculations for a woman
     */
    public static final int WOMAN_MIN_WEIGHT = 100;
    
    /**
     * Highest weight value used in calculations for a woman
     */
    public static final int WOMAN_MAX_WEIGHT = 140;
    
    /**
     * Constant used for the nested gender-separated table printing loops
     */
    public static final int WEIGHT_INCREMENT = 20;
    
    /**
     * Number of drinks
     */
    public static final int MAX_DRINKS = 10;
    
    /**
     * Hours spent drinking
     */
    public static final int MAX_HOURS = 3;
    
    
    
    /**
     * Starts the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        /**
         * Creates a table for the values
         * Nested loop for table -> two nested same level (drinks -> 2gender)
         */
         
        /**
         * Start of table
         */
        System.out.print("                          ");
        System.out.println("Blood Alcohol Content (BAC)");
        System.out.print("Drinks   ");
        System.out.print("              Man              "); //14 either side
        System.out.println("             Woman"); //13
        
        /**
         * Table header numbers (hours then male then female then dashes)
         */
        System.out.printf("(%d hrs)  ", MAX_HOURS);
        
        System.out.printf(" (%d lbs) ", MAN_MIN_WEIGHT);
        System.out.printf("(%d lbs) ", (MAN_MIN_WEIGHT + MAN_MAX_WEIGHT) / 2);
        System.out.printf("(%d lbs) ", MAN_MAX_WEIGHT);
        
        System.out.printf(" (%d lbs) ", WOMAN_MIN_WEIGHT);
        System.out.printf("(%d lbs) ", (WOMAN_MIN_WEIGHT + WOMAN_MAX_WEIGHT) / 2);
        System.out.printf("(%d lbs) \n", WOMAN_MAX_WEIGHT);
        
        System.out.print("-------  ");
        System.out.print(" --------- --------- --------- ");
        System.out.print(" --------- --------- --------- \n");
         
        for(int i = 1; i <= MAX_DRINKS; i++) {   
            /**
             * Print number of drinks (first column)
             */ 
            System.out.printf("%4d   ", i);
            
            /**
             * Male
             */
            for(int j = MAN_MIN_WEIGHT; j <= MAN_MAX_WEIGHT; j += WEIGHT_INCREMENT) {
                double mBac = calculateBAC(MAN_CONSTANT, j, i, MAX_HOURS);
                System.out.printf("%10.3f", mBac);
            }
            
            System.out.print(" ");
            
            /**
             * Female
             */
            for(int k = WOMAN_MIN_WEIGHT; k <= WOMAN_MAX_WEIGHT; k += WEIGHT_INCREMENT) {
                double fBac = calculateBAC(WOMAN_CONSTANT, k, i, MAX_HOURS);
                System.out.printf("%10.3f", fBac);
            }
            
            System.out.println();
        }
    }
    
/**
 * The following comments and equation were pulled from the website, but
 * the equation was rearranged and code was added
 
 * Calculates Blood Alcohol Content (BAC) based on a person's gender, weight,
 * the number of drinks that have been consumed, and the number of hours 
 * since the first drink was consumed.
 * 
 * Does not return negative values (use of Math.max)
 *
 * @param genderConstant gender constant for person
 * @param weight weight of person
 * @param numberOfDrinks number of drinks consumed by person
 * @param hoursDrinking number of hours since first drink was consumed
 * @return Returns the calculated blood alcohol content if it is positive, 0.0 otherwise
 */        
    public static double calculateBAC(double genderConstant, double weight, 
                                    int numberOfDrinks, int hoursDrinking) {
        double theBAC = (numberOfDrinks / weight) * (genderConstant / 2) 
            - (BAC_CONSTANT * hoursDrinking);
        return Math.max(0, theBAC);
    }
}