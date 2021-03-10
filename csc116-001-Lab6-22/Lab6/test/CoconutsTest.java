/**
 * Tests method that prints results for coconuts puzzle
 * 
 * @author Jessica Young Schmidt
 */
public class CoconutsTest {

    /**
     * The method that is executed when the program is run
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Method call: Coconuts.printResults(0)");
        System.out.println();

        System.out.println("Expected:\n" + "The initial number of coconuts is 12495.\n"
                + "Sailor 1: 2499 coconuts; Monkey: 1 coconut.\n"
                + "Sailor 2: 1999 coconuts; Monkey: 1 coconut.\n"
                + "Sailor 3: 1599 coconuts; Monkey: 1 coconut.\n"
                + "Sailor 4: 1279 coconuts; Monkey: 1 coconut.\n"
                + "Sailor 5: 1023 coconuts; Monkey: 1 coconut.\n"
                + "4091 coconuts remain, each sailor gets 818 and 1 for the monkey.");
        System.out.println();

        System.out.println("Actual:");
        Coconuts.printResults(0);
        System.out.println();

        System.out.println("--------------------------------------------------------------------");

        System.out.println("Method call: Coconuts.printResults(1)");
        System.out.println();

        System.out.println("Expected:\n" + "The initial number of coconuts is 28120.\n"
                + "Sailor 1: 5624 coconuts; Monkey: 1 coconut.\n"
                + "Sailor 2: 4499 coconuts; Monkey: 1 coconut.\n"
                + "Sailor 3: 3599 coconuts; Monkey: 1 coconut.\n"
                + "Sailor 4: 2879 coconuts; Monkey: 1 coconut.\n"
                + "Sailor 5: 2303 coconuts; Monkey: 1 coconut.\n"
                + "9211 coconuts remain, each sailor gets 1842 and 1 for the monkey.");
        System.out.println();

        System.out.println("Actual:");
        Coconuts.printResults(1);
        System.out.println("End of Test.");

    }

}
