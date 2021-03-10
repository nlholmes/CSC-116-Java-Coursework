import java.util.Scanner;

import org.junit.Test;
import junit.framework.TestCase;

/**
 * This program tests FlipLines.java
 *
 * @author Nathan Holmes and Alexis Voulgaropoulos
 */
public class FlipLinesTest extends TestCase {

    @Test
    public void testFlipLines1() {
        // Single line
        String input = "one line";
        String description = "Single line of input";
        String expected = input + "\n";
        String actual = FlipLines.flipLines(new Scanner(input));
        assertEquals(description, expected, actual);
    }

    @Test
    public void testFlipLines2() {
        // Two lines
        String input = "two\nlines";
        String description = "Two lines of input";
        String expected = "lines\ntwo\n";
        String actual = FlipLines.flipLines(new Scanner(input));
        assertEquals(description, expected, actual);
    }

    @Test
    public void testFlipLines3() {
        // Three lines
        String input = "three\nlines\nof input";
        String description = "Three lines of input";
        String expected = "lines\nthree\nof input\n";
        String actual = FlipLines.flipLines(new Scanner(input));
        assertEquals(description, expected, actual);
    }

    @Test
    public void testFlipLines4() {
        // Four lines
        String input = "four\nlines\nof input\n!!!!";
        String description = "Four lines of input";
        String expected = "lines\nfour\n!!!!\nof input\n";
        String actual = FlipLines.flipLines(new Scanner(input));
        assertEquals(description, expected, actual);
    }

    @Test
    public void testFlipLines0() {
        // Empty String
        String input = "";
        String description = "Empty String";
        String expected = "";
        String actual = FlipLines.flipLines(new Scanner(input));
        assertEquals(description, expected, actual);
    }

}
