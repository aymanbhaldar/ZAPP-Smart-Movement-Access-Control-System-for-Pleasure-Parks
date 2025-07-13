
/**
 * Write a description of class ChildCard here.
 *
 * @author Ayman A. Bhaldar 
 * @version 11/1/24
 */
public class ChildCard extends Card
{
    private int parentCardNo;
    private int noOfVisits = 0;
    /** Creates a  child card
     * @param idNumber represents the child card's id number
     * @param n represents the child's name
     * @param luxury rating which will always be 10 so defaulted to 10
     * @param credits represents the credits
     */
    public ChildCard (int idNumber, int pcn, int visits, String name, int credits)
    {
        super(idNumber, name, 10, credits);
        parentCardNo = pcn;
        noOfVisits = visits;
        
    }
    
    /**Returns Parent's Card Id Number
     * @return parent card id number
     */
    public int getParentCardNo()
    {
        return parentCardNo;
    }
    
    /** Returns the number of area the child has visited
     * @return number of visits done by child
     */
    public int getNoOfVisits()
    {
        return noOfVisits;
    }
    
    /** Method returning boolean true,
     *  child card doesn't require credits to move across bridge
     */
    public boolean hasCredits()
    {
        if ( this.getCredits() >=0)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    /** @override
     * Method to update card details after moing across bridge
     * 
     */
    public void updateCard()
    {
        //call to parent class
        super.updateChildCard();
        noOfVisits= noOfVisits + 1;
    }
    
    /** @overrides which overrides toString() in Card to include subclass data
     * Method returning a string representation of Child Card with all details,
     * including No of visits and Parent Card Id number
     */    
    public String toString()
        {
            String s;
            //call to parent class
            s = super.toString() + "\nParent's Card ID Number: " + parentCardNo
            + "\nNumber of Visits: " + noOfVisits ;
            return s;
            
        }
    
    
}
