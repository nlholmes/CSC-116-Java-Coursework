import java.util.*;
/**
 * Gives details for holiday travelling
 * @author Nathan Holmes
 */
 
public class HolidayTravel {
    
    /**
     * Days in a week
     */
    public static final int DAYS_IN_WEEK = 7;
    /**
     * Frequency of leap year
     */
    public static final int LEAP_YEAR_FREQUENCY = 4;
    /**
     * Maximum days in a month
     */
    public static final int DAYS_IN_MONTH = 31;
    /**
     * Number of years in a century
     */
    public static final int YEARS_IN_CENTURY = 100;
    /**
     * Number of months in a year
     */
    public static final int MONTHS_IN_YEAR = 12;
    /**
     * CLT ticket price
     */
    public static final int CLT_TICKET = 50;
    /**
     * WDC ticket price
     */
    public static final int WDC_TICKET = 100;
    /**
     * NYC ticket price
     */
    public static final int NYC_TICKET = 180;
    /**
     * Maximum value for a day of the week, 
     * with Sunday starting at 0 and Friday not included as a weekday
     */
    public static final int DAY_OF_WEEK_MAX = 4;
    /**
     * December month value
     */
    public static final int DECEMBER = 12;
    /**
     * November month value
     */
    public static final int NOVEMBER = 12;
    /**
     * January month value
     */
    public static final int JANUARY = 1;
    /**
     * Maximum days in November
     */
    public static final int MAX_NOVEMBER_DAYS = 30;
    /**
     * Maximum days in January
     */
    public static final int MAX_JANUARY_DAYS = 15;
    /**
     * Maximum days in December
     */
    public static final int MAX_DECEMBER_DAYS = 31;
    /**
     * The year 2018
     */
    public static final int YEAR_2018 = 2018;
    /**
     * The year 2019
     */
    public static final int YEAR_2019 = 2019;
    
    /**
     * Starts the program
     * @param args command line arguments
     */
    public static void main(String[] args){
        /** Test cases for areValidDates
        System.out.println(areValidDates(11,4,12,3)); // true
        System.out.println(areValidDates(12,4,1,3)); // true dec to jan
        System.out.println(areValidDates(11,4,11,9)); // true same month
        System.out.println();
        System.out.println(areValidDates(6,4,12,3)); // false
        System.out.println(areValidDates(1,4,12,3)); 
                // false -- cannot start in january and return in dec
        System.out.println(areValidDates(11,31,12,3)); // false -- november 31        
        System.out.println(areValidDates(11,4,11,31)); // false same month nov 31
        System.out.println(areValidDates(12,4,1,16)); // false jan 16
        */
        
        /** Test cases for getCost
        System.out.println("Total Cost: " + getCost("WDC", 1, 3,true)); // 310
        System.out.println();
        System.out.println("Total Cost: " + getCost("WDC", 5, 3,true)); // 570
        System.out.println();
        System.out.println("Total Cost: " + getCost("NYC", 6, 2, false)); // 1260
        System.out.println();
        System.out.println("Total Cost: " + getCost("CLT", 1, 12, true)); // 495
        System.out.println();
        System.out.println("Total Cost: " + getCost("WDC", 3, 3, true)); // 390
        System.out.println();
        System.out.println("Total Cost: " + getCost("NYC", 1, 0, false)); // 180
        System.out.println();
        System.out.println("Total Cost: " + getCost("CLT", 16, 22, false)); // 1500
        System.out.println();
        
        System.out.println("Total Cost: " + getCost("WDC", 0, 3,true)); 
                    // IAE children cannot ride alone
        System.out.println();
        System.out.println("Total Cost: " + getCost("WDC", -1, 0,true)); // IAE negative tickets
        System.out.println();
        System.out.println("Total Cost: " + getCost("WDC", -1, -4,true)); 
                    // IAE negative tickets
        System.out.println();
        */
        
        /**
         * Opening statement and instructions --- from class website
         */
        System.out.println("        Thanks for choosing the Holiday Travel Special!");
        System.out.println("All trips depart from and return to Raleigh, NC, and must take");
        System.out.println("place between Nov 1, 2018 and Jan 15, 2019. When prompted, please");
        System.out.println("enter your destination: CLT (Charlotte,NC), WDC (Washington,DC),");
        System.out.println("or NYC (New York,NY), your departure/return dates, and the number");
        System.out.println("of adult and child tickets you would like to purchase - at least");
        System.out.println("one adult ticket must be purchased in order to purchase child");
        System.out.println("tickets. The total cost of the tickets will then be displayed.");
        System.out.println();
        
        /** 
         * Scanner and getting inputs, also exiting if invalid
         */
        Scanner console = new Scanner(System.in);
        
        System.out.print("Destination (CLT, WDC, NYC): ");
        String destination = console.next();
        destination = destination.toUpperCase();
        if(destination.equals("CLT") == false
                        && destination.equals("WDC") == false 
                            && destination.equals("NYC") == false) {
            System.out.println("Invalid destination");
            System.exit(1);
        }
        
        System.out.print("Departure Month Day (e.g., 11 10): ");
        int depMon = console.nextInt();
        int depDay = console.nextInt();
        
        System.out.print("Return Month Day (e.g., 11 15): ");
        int retMon = console.nextInt();
        int retDay = console.nextInt();
        
        if(areValidDates(depMon, depDay, retMon, retDay) == false) {
            System.out.println("Invalid date(s)");
            System.exit(1);
        }
        
        System.out.print("Number of Adult Tickets: ");
        int adultTickets = console.nextInt();
        if(adultTickets < 0) {
            System.out.println("Invalid number of tickets");
            System.exit(1);
        }
        int childTickets;
        if(adultTickets > 0) {
            System.out.print("Number of Child Tickets: ");
            childTickets = console.nextInt();
            if(childTickets < 0) {
                System.out.println("Invalid number of tickets");
                System.exit(1);
            }
        } else {
            childTickets = 0;
        }
        
        
        /**
         * Determining year of travel: 2018 for month 11 and 12, 2019 for month 1
         */
        int depYear;
        int retYear;
        /** 
         * For departure year
         */
        if(depMon == NOVEMBER || depMon == DECEMBER) {
            depYear = YEAR_2018;
        } else {
            depYear = YEAR_2019;
        }
        
        /**
         * For return year
         */
        if(retMon == NOVEMBER || retMon == DECEMBER) {
            retYear = YEAR_2018;
        } else {
            retYear = YEAR_2019;
        }
        
        
        /**
         * Calculating cost of trip
         * First determine if it is weekday travel, in that both the departure and
         *      return are on a weekday
         */
        boolean weekdayDeparture = isWeekday(depMon, depDay, depYear);
        boolean weekdayReturn = isWeekday(retMon, retDay, retYear);
        boolean weekdayTravel;
        
        /**
         * Determining if it is weekday travel
         */
        if(weekdayDeparture == true && weekdayReturn == true) {
            weekdayTravel = true;
        } else {
            weekdayTravel = false;
        }
        
        /**
         * Calculating the cost of the trip
         */
        int cost = getCost(destination, adultTickets, childTickets, weekdayTravel);
        
        /**
         * Printing the information of the trip
         */
        System.out.println("Cost of Tickets: $" + cost + ".00");
    }
    
    /**
     * Determines if dates are betwen Nov 1 2018 and Jan 15 2019
     * @param departureMonth month leave for travel
     * @param departureDay day leave for travel
     * @param returnMonth month return from travel
     * @param returnDay day return from travel
     * @return boolean value true if date is valid
     */
    public static boolean areValidDates (int departureMonth, int departureDay,
                                     int returnMonth, int returnDay){
        /**                                 
        // test invalid input month as cause of invalidity (invalid range)
        // if either month input is > 12 or <= 0 --- false
        //      if depMon > 12 || depMon <= 0 || retMon > 12 || retMon <= 0
        
        // test month validity for valid ranging input
        // if depMon is after retMon, except if retMon is january (1) --- false
        //      if depMon > retMon && retMon != 1
        // if depMon or retMon is before 11 or after 1 -- false
        //      if depMon > 1 && depMon < 11 || retMon > 1 && retMon < 11
        
        // now do same for days
        // invalid range --- there is no 31st of november... do I need to worry about that?
        // if depDay > 31 || retDay > 31 || depDay <= 0 || retDay <= 0 --- false
        //      conditional for november: 
                    if depDay > 30 && depMonth == 11 || retDay > 30 && dePMonth == 11 --- false
        
        // if depDay or retDay are before 11/01/2018 or after 01/15/2019 --- false
        // if it is january, only serve the first 15 days
        //      if depMon == 1 || retMon == 1
        //          if depDay > 15 || retDay > 15 --- false
        */
        
        if(departureMonth > DECEMBER || departureMonth <= 0 || returnMonth > DECEMBER 
                    || returnMonth <= 0) { // invalid range
            return false;
        // dec to jan is true special case conditional included
        } else if(departureMonth > returnMonth && returnMonth != JANUARY) { 
            return false;
        } else if(departureMonth > JANUARY && departureMonth < NOVEMBER 
                    || returnMonth > JANUARY && returnMonth < NOVEMBER) {
            return false;
        } else if(departureMonth == returnMonth 
                    && departureDay > returnDay) { // departure day after return day in same month
            return false;
        } else if(departureDay > MAX_DECEMBER_DAYS || returnDay > MAX_DECEMBER_DAYS 
                    || departureDay <= 0 || returnDay <= 0) { // days  
            return false;
        } else if(departureMonth == NOVEMBER && departureDay > MAX_NOVEMBER_DAYS 
                    || returnMonth == NOVEMBER && returnDay > MAX_NOVEMBER_DAYS) { 
                            // november special case
            return false;
        } else if(departureMonth == JANUARY && departureDay > MAX_JANUARY_DAYS 
                    || returnMonth == JANUARY && returnDay > MAX_JANUARY_DAYS) { 
                            // january special case
            return false;
        } else if(departureMonth == JANUARY && returnMonth > JANUARY) { 
                    // january is departure month and not return month special case
            return false;
        } else {
            return true;
        }        
    }
    
    /**
     * Determines if input is a weekday using Zeller's algorithm, formula from class website
     *      Friday is not considered a weekday
     * @param month date's month
     * @param day date's day
     * @param year date's year
     * @return boolean value true if date is weekday
     */
    public static boolean isWeekday (int month, int day, int year) {
        int w = year - (2 * DAYS_IN_WEEK - month) / MONTHS_IN_YEAR;
        int x = w + w / LEAP_YEAR_FREQUENCY - w / YEARS_IN_CENTURY 
                + w / (LEAP_YEAR_FREQUENCY * YEARS_IN_CENTURY);
        int z = month +  MONTHS_IN_YEAR * ((2 * DAYS_IN_WEEK - month - month) 
                / MONTHS_IN_YEAR) - 2;
        int dayOfWeek = (day + x + (DAYS_IN_MONTH * z) / MONTHS_IN_YEAR) % DAYS_IN_WEEK;
        
        /** Used for testing
         * System.out.println(dayOfWeek);
         */
        
        /**
         * If it is Friday(5), Saturday(6), or Sunday(0), then false
         */
        if(dayOfWeek == 0 || dayOfWeek > DAY_OF_WEEK_MAX) {
            return false;
        } else {
            return true;
        }  
    }
    
    /**
     * Determines cost of trip
     * @param destination place travelling to
     * @param numberOfAdultTickets number of adult tickets
     * @param numberOfChildTickets number of child tickets
     * @param weekdayTravel boolean value if travelling during week
     * @return cost of trip
     */
    public static int getCost (String destination, int numberOfAdultTickets, 
                                    int numberOfChildTickets, boolean weekdayTravel) {
        
        int adultPrice;
        int weekdayDiscountTotal;
        /* number of times to apply the child ticket discount (number of adult-child combos) */
        int numChildDiscount;                          
        if(numberOfAdultTickets < 0 || numberOfChildTickets < 0) {
            throw new IllegalArgumentException("Invalid number of tickets");
        } else if(numberOfAdultTickets == 0 && numberOfChildTickets > 0){
            throw new IllegalArgumentException("Invalid number of tickets");
        }
        
        /* the following if statement assumes destination will be put into uppercase beforehand */
        if(destination.equals("CLT") == true) { // Charlotte
            adultPrice = CLT_TICKET;
        } else if(destination.equals("WDC") == true) { // DC
            adultPrice = WDC_TICKET;
        } else if(destination.equals("NYC") == true) { // NYC
            adultPrice = NYC_TICKET;
        } else { // throw exception
            throw new IllegalArgumentException("Invalid destination");
        }
        
        // child discount
        if (numberOfAdultTickets >= numberOfChildTickets) { // if more adults or same
            numChildDiscount = numberOfChildTickets;
        } else { // if more children
            numChildDiscount = numberOfAdultTickets % numberOfChildTickets;
        }
        // weekday discount total price
        // assuming weekdayTravel variable has already boolean 
        //      compared dep and ret dates for if both are weekdays
        if(weekdayTravel == true) { 
            // amount of discount int dollars from weekday travel
            weekdayDiscountTotal = (numberOfAdultTickets + numberOfChildTickets) * 10; 
        } else {
            weekdayDiscountTotal = 0;
        }
        
        
        int totalCost = (numberOfAdultTickets + numberOfChildTickets) * adultPrice 
                - weekdayDiscountTotal - numChildDiscount * (adultPrice / 2);
        /** Was used for testing purposes
        System.out.println("Adult: " + numberOfAdultTickets);
        System.out.println("Child: " + numberOfChildTickets);
        System.out.println("Adult Price: " + adultPrice);
        System.out.println("Weekday Discount Total: " + weekdayDiscountTotal);
        System.out.println("Number Child Discount: " + numChildDiscount);
        */
        return totalCost;
        
    }
}