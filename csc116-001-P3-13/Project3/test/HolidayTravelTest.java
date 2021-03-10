import org.junit.Test;
import junit.framework.TestCase;

/**
 * Program to test HolidayTravel methods
 * @author Suzanne Balik
 * @author Nathan Holmes
 */
public class HolidayTravelTest extends TestCase {
 
    
    @Test
    public void testAreValidDates1() {
        
        assertTrue("HolidayTravel.areValidDates(11, 10, 11, 25)", 
                   HolidayTravel.areValidDates(11, 10, 11, 25));
        
    }

    @Test
    public void testAreValidDates2() {
        
        assertFalse("HolidayTravel.areValidDates(12, 25, 12, 24)", 
                    HolidayTravel.areValidDates(12, 25, 12, 24));
    }
    
    @Test
    public void testAreValidDates3() {
        
        assertTrue("HolidayTravel.areValidDates(11, 4, 12, 3)", 
                    HolidayTravel.areValidDates(11, 4, 12, 3));
    }
    
    @Test
    public void testAreValidDates4() {
        
        assertTrue("HolidayTravel.areValidDates(12, 4, 1, 3)", 
                    HolidayTravel.areValidDates(12, 4, 1, 3));
    }
    
    @Test
    public void testAreValidDates5() {
        
        assertFalse("HolidayTravel.areValidDates(1, 4, 12, 3)", 
                    HolidayTravel.areValidDates(1, 4, 12, 3));
    }
    
    @Test
    public void testAreValidDates6() {
        
        assertFalse("HolidayTravel.areValidDates(11, 4, 11, 31)", 
                    HolidayTravel.areValidDates(11, 4, 11, 31));
    }
    
    @Test
    public void testAreValidDates7() {
        
        assertFalse("HolidayTravel.areValidDates(12, 4, 1, 16)", 
                    HolidayTravel.areValidDates(12, 4, 1, 16));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Test
    public void testIsWeekday1() {
        
        assertTrue("HolidayTravel.isWeekday(3, 16, 2017)", 
                   HolidayTravel.isWeekday(3, 15, 2017));
        
    }
    
    @Test
    public void testIsWeekday2() {
        
        assertFalse("HolidayTravel.isWeekday(12, 30, 2018)", 
                    HolidayTravel.isWeekday(12, 30, 2018));
    }
    
    @Test
    public void testIsWeekday3() {
        
        assertTrue("HolidayTravel.isWeekday(10, 15, 2018)", 
                    HolidayTravel.isWeekday(10, 15, 2018));
    }
    
    @Test
    public void testIsWeekday4() {
        
        assertFalse("HolidayTravel.isWeekday(10, 19, 2018)", 
                    HolidayTravel.isWeekday(10, 19, 2018));
    }
    
    @Test
    public void testIsWeekday5() {
        
        assertFalse("HolidayTravel.isWeekday(3, 2, 2019)", 
                    HolidayTravel.isWeekday(3, 2, 2019));
    }
    
    @Test
    public void testIsWeekday6() {
        
        assertFalse("HolidayTravel.isWeekday(5, 19, 2019)", 
                    HolidayTravel.isWeekday(5, 19, 2019));
    }
    
    @Test
    public void testIsWeekday7() {
        
        assertTrue("HolidayTravel.isWeekday(6, 6, 2017)", 
                    HolidayTravel.isWeekday(6, 6, 2017));
    }
    
    
    
    
    
    
    
    
    
    @Test
    public void testGetCost1() {
        
        assertEquals("HolidayTravel.getCost(\"CLT\", 2, 1, false)", 125,
                     HolidayTravel.getCost("CLT", 2, 1, false));
        
    }

    @Test
    public void testGetCost2() {
        
        assertEquals("HolidayTravel.getCost(\"WDC\", 1, 3, true)", 310,
                     HolidayTravel.getCost("WDC", 1, 3, true));
        
    }

    // TODO: Add 7 more valid test cases here for the getCost method. Each test should be
    // in its own method
    
    @Test
    public void testGetCost3() {
        
        assertEquals("HolidayTravel.getCost(\"WDC\", 0, 3, true)", 0,
                     HolidayTravel.getCost("WDC", 0, 0, true));
        
    }
    
    @Test
    public void testGetCost4() {
        
        assertEquals("HolidayTravel.getCost(\"WDC\", 1, 3, true)", 570,
                     HolidayTravel.getCost("WDC", 5, 3, true));
        
    }
    
    @Test
    public void testGetCost5() {
        
        assertEquals("HolidayTravel.getCost(\"NYC\", 6, 2, false)", 1260,
                     HolidayTravel.getCost("NYC", 6, 2, false));
        
    }
    
    @Test
    public void testGetCost6() {
        
        assertEquals("HolidayTravel.getCost(\"CLT\", 1, 12, true)", 495,
                     HolidayTravel.getCost("CLT", 1, 12, true));
        
    }
    
    @Test
    public void testGetCost7() {
        
        assertEquals("HolidayTravel.getCost(\"WDC\", 3, 3, true)", 390,
                     HolidayTravel.getCost("WDC", 3, 3, true));
        
    }
    
    @Test//
    public void testGetCost8() {
        
        assertEquals("HolidayTravel.getCost(\"NYC\", 1, 0, false)", 180,
                     HolidayTravel.getCost("NYC", 1, 0, false));
        
    }
    
    @Test//
    public void testGetCost9() {
        
        assertEquals("HolidayTravel.getCost(\"CLT\", 16, 22, false)", 1500,
                     HolidayTravel.getCost("CLT", 16, 22, false));
        
    }
    
    /**
     * Test the HolidayTravel.getCost() method with invalid values
     */ 
    @Test
    public void testGetCostInvalid() {
        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!
        try {
            HolidayTravel.getCost("xyz", 2, 1, false);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid destination", e.getMessage());
        }

        try {
            HolidayTravel.getCost("CLT", -2, 1, false);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid number of tickets", e.getMessage());
        }
        
        try {
            HolidayTravel.getCost("WDC", 0, 1, false);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid number of tickets", e.getMessage());
        }  
    }
}