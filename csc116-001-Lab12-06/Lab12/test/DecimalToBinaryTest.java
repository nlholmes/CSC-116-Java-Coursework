import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This program tests AllDigitsOdd
 * 
 * @author Nathan Holmes and Alexis Voulgaropoulos
 *
 */
public class DecimalToBinaryTest {

    
    /**
     * Test the special case of a zero
     */
    @Test
    public void testConvertToBinaryValid() {
        String id = "Zero";
        String desc = "DecimalToBinary.convertToBinary(0)";
        String expected = "0";
        String actual = DecimalToBinary.convertToBinary(0);
        assertEquals(id, expected, actual);
    }
    
    /**
     * Tests -1 and other negative inputs from the user
     */
    @Test
    public void testConvertToBinaryInvalid() {
        try {
            DecimalToBinary.convertToBinary(-1);
            fail("-1");
        } catch (IllegalArgumentException e) {
            assertEquals("-1", "Negative value: -1", e.getMessage());
        }

        try {
            DecimalToBinary.convertToBinary(-2468);
            fail("-2468");
        } catch (IllegalArgumentException e) {
            assertEquals("-2468", "Negative value: -2468", e.getMessage());
        }
    }
    
    /**
     * Tests maximum value for an integer
     */
    @Test
    public void testConvertToBinaryMax() {
        assertEquals("Testing 2,147,483,647", "1111111111111111111111111111111", 
                            DecimalToBinary.convertToBinary(2147483647));
    }
    
    /**
     * Tests valid input
     */
    @Test
    public void testConvertToBinaryValidInput() {
        assertEquals("Testing 44", "101100", DecimalToBinary.convertToBinary(44));
    }
    
    /**
     * Tests input with zeros in the middle
     */
    @Test
    public void testConvertToBinaryWithZeros() {
        assertEquals("Testing 1007", "1111101111", DecimalToBinary.convertToBinary(1007));
    }
    
    /**
     * Tests input with only odd numbers
     */
    @Test
    public void testConvertToBinaryFrontZeros() {
        assertEquals("Testing 953", "1110111001", DecimalToBinary.convertToBinary(953));
    }
}
