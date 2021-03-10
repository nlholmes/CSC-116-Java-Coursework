import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Program to test PayGap methods
 * @author Suzanne Balik
 * @author Nathan Holmes
 */
public class PayGapTest extends TestCase {

    public static final Job BUTCHER = new Job("Butcher", 34200, 36575);
    
    public static final Job BAKER = new Job("Baker", 29800, 30450);
    
    public static final Job CANDLESTICK_MAKER = new Job("Candlestick maker", 34080, 39896);
    
    public static final Job[] THREE_JOBS = { BUTCHER, BAKER, CANDLESTICK_MAKER };
    
    public static final Job LEMONADE_SALESPERSON = new Job("Lemonade Salesperson", 11000, 11300);
    
    public static final Job APIARIST = new Job("Apiarist", 11500, 14050);
    
    public static final Job BREAD_SCIENTIST = new Job("Bread Scientist", 135700, 145600);
    
    public static final Job[] MY_JOBS = { LEMONADE_SALESPERSON, APIARIST, BREAD_SCIENTIST };

    @Test
    public void testGetJobList1() {
        String filename = "test-files/three_jobs.csv";
        Job[] actual = PayGap.getJobList(filename);
        assertTrue(filename, Arrays.equals(THREE_JOBS, actual));
    }

    @Test
    public void testGetJobList2() {
        String filename = "test-files/my_jobs.csv";
        Job[] actual = PayGap.getJobList(filename);
        assertTrue(filename, Arrays.equals(MY_JOBS, actual));
    }

    @Test
    public void testGetAllJobs1() {
        String expected = "Butcher                                                   "
                + "             34200    36575\n"
                + "Baker                                                             "
                + "     29800    30450\n"
                + "Candlestick maker                                                 "
                + "     34080    39896\n";
        String actual = PayGap.getAllJobs(THREE_JOBS);
        assertEquals("Three jobs", expected, actual);
    }

    @Test
    public void testGetAllJobs2() {
        String expected = "Lemonade Salesperson                                      "
                + "             11000    11300\n"
                + "Apiarist                                                          "
                + "     11500    14050\n"
                + "Bread Scientist                                                   "
                + "    135700   145600\n";
        String actual = PayGap.getAllJobs(MY_JOBS);
        assertEquals("My Jobs", expected, actual);
    }
    
    @Test
    public void testSearchByJob1() {
        String expected = "Candlestick maker                                         "
                + "             34080    39896\n";
        String actual = PayGap.searchByJob("ck ma", THREE_JOBS);
        assertEquals("Three jobs", expected, actual);
    }

    @Test
    public void testSearchByJob2() {
        String expected = "Bread Scientist                                           "
                + "            135700   145600\n";
        String actual = PayGap.searchByJob("ad sc", MY_JOBS);
        assertEquals("My Jobs", expected, actual);
    }

    @Test
    public void testSearchBySalaryRange1() {
        String expected = "Butcher                                                    "
                + "            34200    36575\n";
        String actual = PayGap.searchBySalaryRange(34000, 37000, THREE_JOBS);
        assertEquals("Three jobs", expected, actual);
    }

    // TODO: Add 1 more test cases here for searchBySalaryRange method. Each test should be
    // in its own method.
    @Test
    public void testSearchBySalaryRange2() {
        String expected = "Lemonade Salesperson                                       "
                + "            11000    11300\n";
        String actual = PayGap.searchBySalaryRange(11000, 12000, MY_JOBS);
        assertEquals("My Jobs", expected, actual);
    }
    
    @Test
    public void testSearchByPercentage1() {
        String expected = "Butcher                                                  "
                + "              34200    36575\n"
                + "Candlestick maker                                                "
                + "      34080    39896\n";
        String actual = PayGap.searchByPercentage(95, THREE_JOBS);
        assertEquals("Three jobs", expected, actual);
    }

    @Test
    public void testSearchByPercentage2() {
        String expected = "Apiarist                                                 "
                + "              11500    14050\n";
        String actual = PayGap.searchByPercentage(93, MY_JOBS);
        assertEquals("My Jobs", expected, actual);
    }
    
    /**
     * Test the PayGap methods with invalid values
     */ 
    @Test
    public void testSearchInvalid() {
        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!
        try {
            PayGap.searchBySalaryRange(40000, 37000, THREE_JOBS);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid min/max value", e.getMessage());
        }

        try {
            PayGap.searchBySalaryRange(-300, 37000, THREE_JOBS);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid min/max value", e.getMessage());
        }

        try {
            PayGap.searchBySalaryRange(40000, -50000, THREE_JOBS);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid min/max value", e.getMessage());
        }

        try {
            PayGap.searchByPercentage(0, THREE_JOBS);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid percentage value", e.getMessage());
        }

        try {
            PayGap.searchByPercentage(101, THREE_JOBS);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid percentage value", e.getMessage());
        }
    }

}