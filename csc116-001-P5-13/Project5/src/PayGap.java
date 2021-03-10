import java.util.*;
import java.io.*;
/**
 * Program to examine male and female salaries
 * @author Nathan Holmes
 */
 
public class PayGap {
    // Wanted to add jobListHeader() to the return of the methods, but causes them to fail the WBT
    // use console.hasNextInt() maybe, might eliminate need to parse the inputs
    
    /**
     * Start the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // if there was not exactly one command line argument
        // then display usage message and exit program
        if (args.length != 1) {
            System.out.println("Usage: java -cp bin PayGap filename");
            System.exit(1);
        }
        
        
        // args is a string array, I believe the first element will be the input file
        String filename = args[0]; // file location/name
        //System.out.println(filename);
        
        
        Job[] jobList = new Job[0];
        try {
            jobList = getJobList(filename);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        userInterface(jobList);
    }
    
    
    
    /**
     * Handles the input from the user and runs program
     * @param jobList list of all job objects
     */
    public static void userInterface(Job[] jobList) {
        Scanner console = new Scanner(System.in);
        
        // option character input from user, used in the truncation of option (commented out)
        char option; 
        String optionStr;
        boolean valid ; // valid input variable for option 's' and 'p'
        do {
            header(); // prints out the header for the program
            
            /**
             * GETTING THE OPTION FROM THE USER
             */
            System.out.print("Option: ");
            // Commented out below accepts entire word
            // gets first char of choice and makes it lower case
            //option = Character.toLowerCase(console.next().charAt(0));
            
            // This will only run the option if the user enters only a character
            optionStr = console.next().toLowerCase();
            
            if (optionStr.length() == 1) { // if optionStr is a character, input option is valid
                valid = true;
                // optionStr can only have one character here, so make it a character
                option = optionStr.charAt(0); 
            } else { // if optionStr is not a character, do not go into the option if statements
                valid = false;
                option = '0'; // do not run option if statements, but still initialize option
            }
            //System.out.println(option);
            
            // if statements for choice
            
            //valid = true;
            if (option == 'd') { // display all jobs as strings
                
                jobListHeader(); // prints job list header
                // uses created method to print the array of job objects
                System.out.println(getAllJobs(jobList)); 
                
            } else if (option == 'j') { // search by job
            
                // phrase to search for in all jobs
                System.out.print("Job (contains/is): ");
                
                
                // nextLine reads enter, need to skip it 
                // happened on last projec too
                
                
                console.nextLine(); 
                //make this nextLine() and might have to console.next() 
                //beforehand to fix nextLine reading the enter
                //or maybe just make the previous 'option' one next line 
                //as well but then will break if space is first
                String jobPhrase = console.nextLine(); 
                                                   
                                                   
                //System.out.println(jobPhrase);
                // finds all jobs in the list containing the phrase in their title and prints
                jobListHeader();
                System.out.println(searchByJob(jobPhrase, jobList));
                
            } else if (option == 's') { // search by salary range
                int rangeMin = 0; // variables for parsed integers
                int rangeMax = 0;
                
                System.out.print("Minimum Salary: ");
                String rangeMinStr = console.next(); // make them strings now, parse them later
                // Tests for valid minimum input
                try {
                    rangeMin = Integer.parseInt(rangeMinStr); // makes string input an integer
                }
                catch (NumberFormatException e) {
                    // if not an integer, rerun the loop and tell the user
                    //throw new NumberFormatException("Invalid input"); 
                    valid = false;
                    System.out.println("Invalid value");
                }
                
                if(rangeMin < 0) { // do not get another input if the minimum value is negative
                    valid = false;
                    System.out.println("Invalid value");
                    System.out.println();
                }
                
                
                // only promp user again if the minimum input was valid
                if (valid == true) { 
                    System.out.print("Maximum Salary: ");
                    String rangeMaxStr = console.next();
                    // Tests for valid maximum input
                    try {
                        rangeMax = Integer.parseInt(rangeMaxStr);
                    }
                    catch (NumberFormatException e) {
                        // if not an integer, rerun the loop and tell the user
                        //throw new NumberFormatException("Invalid input"); 
                        valid = false;
                        System.out.println("Invalid value");
                        System.out.println();
                    }
                    
                    if (rangeMax < 0 || rangeMax < rangeMin) {
                        valid = false;
                        System.out.println("Invalid value");
                        System.out.println();
                    } else { // if rangeMax was positive, valid was true
                        // catches exception if invalid min or max value, 
                        //      only do this if valid is true
                        try {
                            jobListHeader();
                            System.out.println(searchBySalaryRange(rangeMin, rangeMax, jobList));
                        }
                        catch (IllegalArgumentException e) {
                            valid = false;
                            //System.out.println(e.getMessage());
                            System.out.println("Invalid value");
                            System.out.println();
                        }
                    }
                }
                
            } else if (option == 'p') { // search by percentage
                 
                System.out.print("Percentage: ");
                String percStr = console.next();
                
                int perc = 0;
                // tests if input is integer
                try {
                    perc = Integer.parseInt(percStr); // makes string input an integer
                }
                catch (NumberFormatException e) {
                    valid = false;
                }
                
                if (perc < 1 || perc > 100) { // if perc has invalid range, print invalid value
                    System.out.println("Invalid value");
                    System.out.println();
                } else { // if perc has valid range
                    // catches exception if invalid percentage value
                    try {
                        jobListHeader();
                        System.out.println(searchByPercentage(perc, jobList));
                    }
                    catch (IllegalArgumentException e) {
                        //System.out.println(e.getMessage());
                        System.out.println("Invalid value");
                        System.out.println();
                        valid = false;
                    }
                }
            } else if (option == 'q') {
                
                System.out.println();
                System.out.println("Goodbye!"); // say goodbye if they choose to quit
                
            } else if (option != 'q') { // only print this if they aren't quitting the program
                
                System.out.println("Invalid option");
                System.out.println();
                
            }
        } while (option != 'q' || valid == false);
        console.close();
    }
    
    
    /**
     * Gets list of jobs
     * @param filename name of file
     * @return list of jobs
     * Skeleton was taken from class website
     */
    public static Job[] getJobList(String filename) {
        // try/catch for FNF from class website, modified --> maybe make into method as use twice
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File(filename));
        }
        catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Unable to access input file: " + filename);
        }
        
        int numLines = 0;

        while (fileScanner.hasNextLine()) {
            // Counts the number of jobs
            numLines++;
            fileScanner.nextLine();
        }
        
        //System.out.println(numLines);
        // Initialize job array to number of lines
        Job[] jobs = new Job[numLines];
        
        
        // Get job array info
        // creates another scanner to start from beginning
        
        // Second instance of class website code for try/catch
        Scanner fileScannerTwo = null;
        try {
            fileScannerTwo = new Scanner(new File(filename));
        }
        catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Unable to access input file: " + filename);
        }     
        
        
        // Repeat for number of lines in file
        for (int i = 0; i < numLines; i++) {
            Scanner lineScanner = new Scanner(fileScannerTwo.nextLine());
            lineScanner.useDelimiter(","); 
                // sets delimeter
            // file format: job title, femSal, malSal
            String jobName = lineScanner.next();
            
            
            // the file formatting from the website is messing things up
            int femSal = lineScanner.nextInt();
            int malSal = lineScanner.nextInt();
            //System.out.println(femSal);
            
            jobs[i] = new Job(jobName, femSal, malSal);
            
            
        }
        return jobs;
        
        //return null;
    }
    
    /**
     * Returns string of all jobs in list, each on a new line
     * @param jobs array of jobs
     * @return strings of jobs
     * Skeleton was taken from class website
     */
    public static String getAllJobs(Job[] jobs) {
        String allJobs = "";
        for (int i = 0; i < jobs.length; i++) {
            // converts to string, adds new line after each job
            allJobs += jobs[i].toString() + "\n"; 
        }
        return allJobs;
    }
    
    /**
     * Returns a string of job objects that contain a given phrase in their titles
     * @param job phrase of job to get string of
     * @param jobs array of jobs
     * @return string of specific job
     * Skeleton was taken from class website
     */
    public static String searchByJob(String job, Job[] jobs) {
        // make loop for all elements in jobs array
        // get all jobs from array, make them strings (use getter method)
        // make them all lowercase
        // make param job lowercase
        // get index of job phrase in job title
        //      if the index is not -1, need to add that (entire) 
        //      job object in the returned string array
        // compare the two
        String retJobs = ""; // initializes string of jobs to return
        for(int i = 0; i < jobs.length; i++) {
            //gets current job and makes it lowercase, uses getter method from job class
            String currentJob = jobs[i].getJob().toLowerCase(); 
            job = job.toLowerCase(); //makes job phrase lowercase
            // if current job contains job phrase, add it to string array (index =! -1)
            if(currentJob.indexOf(job) != -1) { 
                // if current job title contains the phrase, need to return it
                retJobs += jobs[i].toString() + "\n"; 
            }
        }
        //return "";
        return retJobs;
    }
    
    /**
     * Returns all jobs within a range of salary
     * @param min minimum of salary range
     * @param max maximum of salary range
     * @param jobs array of jobs
     * @return strings of jobs within the salary range
     * Skeleton was taken from class website
     */
    public static String searchBySalaryRange(int min, int max, Job[] jobs) {
        // precondition: min and max are ints
        String rangeJobs = "";
        
        if (min < 0 || max < 0 || min > max) {
            throw new IllegalArgumentException("Invalid min/max value");
        }
        
        for(int i = 0; i < jobs.length; i++) {
            int femSal = jobs[i].getFemaleSalary();
            int malSal = jobs[i].getMaleSalary();
            if(femSal <= max && malSal <= max && femSal >= min && malSal >= min) {
                rangeJobs += jobs[i].toString() + "\n";
            }
        }
        
        
        return rangeJobs;
    }
    
    /**
     * Returns strings of jobs that female salary is a percentage less than male salary
     * @param percentage the percentage of male salary the female salaries are less than
     * @param jobs array of jobs
     * @return all jobs that fall within the percentage range
     * Skeleton was taken from class website
     */
    public static String searchByPercentage(int percentage, Job[] jobs) {
        // precondition: percentage is int
        String percJobs = "";
        
        // IllegalArgumentException -- > need to catch this in userInput()
        if (percentage < 1 || percentage > 100) {
            throw new IllegalArgumentException("Invalid percentage value");
        }
        
        for(int i = 0; i < jobs.length; i++) {
            int femSal = jobs[i].getFemaleSalary();
            int malSal = jobs[i].getMaleSalary();
        
            // compares salaries
            // executes if percentage times current male salary is 
            //      greater than current female salary
            if(femSal < percentage / 100.0 * malSal) {
                percJobs += jobs[i].toString() + "\n";
            }
        }

        return percJobs;
    }
    
    /**
     * Prints main program header
     */
    public static void header() {
        System.out.println("Gender Pay Gap Information - Please enter an option below.");
        System.out.println();
        System.out.println("D - Display all jobs");
        System.out.println("J - Search by job");
        System.out.println("S - Search by salary range");
        System.out.println("P - Search by percentage");
        System.out.println("Q - Quit the program");
        System.out.println();
    }
    
    
    /**
     * Prints job list header 
     */
    public static void jobListHeader() {
        String line1 = String.format("%-67s%9s%9s", "", "Female", "Male");
        String line2 = String.format("%-67s%9s%9s", "Job Description", "Salary", "Salary");
        String dashes = String.format("%-67s%9s%9s", "---------------", "------", "------");
        
        System.out.print(line1 + "\n" + line2 + "\n" + dashes + "\n\n");
    }
}
   

