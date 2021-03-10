import java.util.Scanner;

import org.junit.Test;
import junit.framework.TestCase;

/**
 * Tests the WeatherReporter class 
 * @author Nathan Holmes and Alexis Voulgaropoulos
 */
public class WeatherReporterTest extends TestCase {

    @Test
    public void testProcessLine() {
        String input = "20100627    85.4    100.9   73  000000";
        String description = "Temperature over 100";
        String expected = "06/27/2010 Low:  73.0 High: 100.9 Rain:  no Snow:  no";
        String actual = WeatherReporter.processLine(input);
        assertEquals(description, expected, actual);
    }

    /**
     * Tests processLine with negative values
     */
    @Test
    public void testProcessLineNegative() {
        assertEquals("Negative Highs and Lows", 
        "00/00/0000 Low: -13.0 High: -33.0 Rain:  no Snow:  no", 
        WeatherReporter.processLine("00000000	-4   	-33	-13	100000"));
    }
    
    /**
     * Tests processLine with true values for rain and snow
     */
    @Test
    public void testGetInput() {
        assertEquals("Rain and snow true", 
        "00/00/0000 Low:   3.0 High:   2.0 Rain: yes Snow: yes", 
        WeatherReporter.processLine("00000000	1   2	3	011000"));
    }
}
