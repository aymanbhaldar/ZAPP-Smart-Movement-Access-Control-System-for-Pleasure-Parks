 

  


/**
 * Details of your team
 * 
 * @author Ayman A. Bhaldar 
 * @version 11/1/24/** Creates a card
 */
public class Teamwork
{
    private String[] details = new String[6];
    
    public Teamwork()
    {   // In each line replace the contents of the String 
        // with the details of your team
        // It will help us if the surname of programmer1 comes
        // alphabetically before the surname of programmer2
        // If there is only 1 team member, please complete details 
        // for programmer1
        
        details[0] = "Bhaldar";
        details[1] = "Ayman";
        details[2] = "18061170";
        
    }
    /**Retruns a string representation of details of the Team Members
     * @return details of team member
     * 
     */
    public String[] getTeamDetails()
    {
        return details;
    }
    
    /**Prints details of team members
     * 
     */
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
