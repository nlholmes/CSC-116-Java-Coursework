import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class ProcessFileTest {

    @Test
    public void testProcessFileSingleInteger() throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File("test-files/test1.txt"));
        String expected = "Maximum = 4\n" + "Minimum = 4\n" + "Sum = 4\n" + "Count = 1\n"
                + "Average = 4.0";
        String actual = ProcessFile.processFile(fileScan);
        assertEquals("Test file with single integer", expected, actual);
    }

    @Test
    public void testGetInputScannerSingleInteger() throws FileNotFoundException {
        // Next lecture we will discuss Scanner for strings
        Scanner fileScan = ProcessFile.getInputScanner(new Scanner("test-files/test1.txt"));
        assertNotNull(fileScan);
        assertTrue("Has integer element", fileScan.hasNextInt());
        assertEquals("Get single element", 4, fileScan.nextInt());
        assertFalse("No other integer element", fileScan.hasNextInt());
        assertFalse("No other element", fileScan.hasNext());
    }

    @Test
    public void testGetInputScannerFileDoesNotExistThenSingleInteger()
            throws FileNotFoundException {
        // Next lecture we will discuss Scanner for strings
        Scanner fileScan = ProcessFile
                .getInputScanner(new Scanner("test-file/non-existent.txt test-files/test1.txt"));
        assertNotNull(fileScan);
        assertTrue("Has integer element", fileScan.hasNextInt());
        assertEquals("Get single element", 4, fileScan.nextInt());
        assertFalse("No other integer element", fileScan.hasNextInt());
        assertFalse("No other element", fileScan.hasNext());
    }

}
