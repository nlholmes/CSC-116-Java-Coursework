import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import junit.framework.TestCase;

//TODO Add javadoc
public class CollapseTest extends TestCase {

    @Test
    public void testCollapseSpaces() throws FileNotFoundException {
        // File with two lines and different spaces
        String inputFile = "test-files/collapse1.txt";
        String expected = "test-files/collapse1_EXPECTED.txt";
        String actual = "test-files/collapse1_ACTUAL.txt";
        Collapse.collapseSpaces(new Scanner(new File(inputFile)),
                new PrintStream(new File(actual)));
        assertFilesEqual(expected, actual);
    }

    /**
     * Tests whether files contain the same contents
     * 
     * @param pathToExpected path to file with expected contents
     * @param pathToActual path to file with actual content
     * @throws FileNotFoundException if Scanner cannot be constructed with file
     */
    private void assertFilesEqual(String pathToExpected, String pathToActual)
            throws FileNotFoundException {
        try (Scanner expected = new Scanner(new File(pathToExpected));
                Scanner actual = new Scanner(new File(pathToActual));) {
            while (expected.hasNextLine()) {
                if (!actual.hasNextLine()) { // checks that actual has line as well
                    fail("Actual missing line(s)");
                } else { // both have another line
                    assertEquals("Checking line equality", expected.nextLine(), actual.nextLine());
                }
            }

            if (actual.hasNextLine()) {
                fail("Actual has extra line(s)");
            }
        }
    }

}
