import static org.junit.Assert.assertEquals;

import org.junit.*;
import junit.framework.TestCase;

/**
 * This program tests AllDigitsOdd
 * 
 * @author Alexis Voulgaropoulos
 *
 */
public class AllDigitsOddTest extends TestCase {
    
    /**
     * Test the AllDigitsOdd.lastDigit() method
     */
    @Test
    public void testLastDigit() {
        assertEquals("AllDigitsOdd.lastdigit(136)", 6, AllDigitsOdd.lastDigit(136));
        assertEquals("AllDigitsOdd.lastdigit(136)", 8, AllDigitsOdd.lastDigit(8));
        assertEquals("AllDigitsOdd.lastdigit(136)", 0, AllDigitsOdd.lastDigit(240));
    }
    
    /**
     * Test the AllDigitsOdd.withoutLastDigit() method
     */
    @Test
    public void testWithoutLastDigit() {
        assertEquals("AllDigitsOdd.withoutLastDigit(136)", 13, AllDigitsOdd.withoutLastDigit(136));
        assertEquals("AllDigitsOdd.withoutLastDigit(136)", 0, AllDigitsOdd.withoutLastDigit(8));
        assertEquals("AllDigitsOdd.withoutLastDigit(136)", 24, AllDigitsOdd.withoutLastDigit(240));
    }
    
    /**
     * Test te AllDigitsOdd.areAllDigitsOdd() method
     */
    @Test
    public void testAreAllDigitsOdd() {
        assertTrue("AllDigitsOdd.areAllDigitsOdd(135)", AllDigitsOdd.areAllDigitsOdd(135));
        assertTrue("AllDigitsOdd.areAllDigitsOdd(135)", AllDigitsOdd.areAllDigitsOdd(-135));
        assertTrue("AllDigitsOdd.areAllDigitsOdd(135)", AllDigitsOdd.areAllDigitsOdd(01357));
        
        
        assertFalse("AllDigitsOdd.areAllDigitsOdd(136)", AllDigitsOdd.areAllDigitsOdd(136));
        assertFalse("AllDigitsOdd.areAllDigitsOdd(136)", AllDigitsOdd.areAllDigitsOdd(417));
        assertFalse("AllDigitsOdd.areAllDigitsOdd(136)", AllDigitsOdd.areAllDigitsOdd(0));
        assertFalse("AllDigitsOdd.areAllDigitsOdd(136)", AllDigitsOdd.areAllDigitsOdd(307));
        assertFalse("AllDigitsOdd.areAllDigitsOdd(136)", AllDigitsOdd.areAllDigitsOdd(570));
        
    }
    
}