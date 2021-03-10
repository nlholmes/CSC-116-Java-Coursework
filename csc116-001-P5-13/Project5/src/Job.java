/**
 * Code taken from class website
 *
 * Encapsulates job and male/female salary information
 * @author Suzanne Balik
 */
public class Job {
   
    /** Job description*/
    private String job;
    
    /** Female salary   */ 
    private int femaleSalary;
  
    /** Male salary */
    private int maleSalary;
      
    /**
     * Constructs and initializes a Job object.
     * @param job job description
     * @param femaleSalary female salary
     * @param maleSalary male salary
     * @throws IllegalArgumentException if job is null
     * @throws IllegalArgumentException if femaleSalary or maleSalary are nonpositive
     */
    public Job (String job, int femaleSalary, int maleSalary) {
        if (job == null) {
            throw new IllegalArgumentException("job is null");
        }
        if (femaleSalary <= 0 || maleSalary <= 0) {
            throw new IllegalArgumentException("femaleSalary or maleSalary is nonpositive");
        }
        this.job = job;
        this.femaleSalary = femaleSalary;
        this.maleSalary = maleSalary;
    }
    
    /**
     * Returns the job
     * @return the job
     */
    public String getJob() {
        return job;
    } 
   
    /**
     * Returns the female salary
     * @return female salary
     */
    public int getFemaleSalary() {
        return femaleSalary;
    }
    
    /**
     * Returns the male salary
     * @return male salary
     */
    public int getMaleSalary() {
        return maleSalary;
    }
    

    /**
     * Determines if the given Job object has the same 
     * state as this Job object
     *
     * @param object Job object to compare 
     * @return true   if given Job object equals this Job object
     *         false  otherwise
     */
    public boolean equals(Object object) {
        if (object instanceof Job) {
            Job other = (Job) object;
            return (job.equals(other.job) && 
                    femaleSalary ==  other.femaleSalary &&
                    maleSalary == other.maleSalary);
        } else {
            return false;
        }
    }


    /**
     * Returns a String representation of the Job object
     * @return String containing job, female salary, and male salary
     */
    public String toString() {
        return String.format("%-67s%9d%9d", job, femaleSalary, maleSalary);
    }
               
}