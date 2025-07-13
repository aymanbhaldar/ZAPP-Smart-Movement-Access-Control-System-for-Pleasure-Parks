
/**
 * Write a description of class CompanyCard here.
 *
 *@author Ayman A. Bhaldar 
 * @version 11/1/24
 */
public class CompanyCard extends Card
{
    /** Creates a  company card
     * @param idNumber represents the company card's id number
     * @param n represents the company's name
     * @param luxRating is the luxury rating of card
     * @param credits is defaulted to 30
     */
    public CompanyCard (int idNumber, String name, int luxRating)
    {
        super(idNumber, name, luxRating, 30);
        
        
    }
    
    /** Method returning boolean true,
     *  if company card has enough credits(3) to pass the bridge
     */
    public boolean hasCredits()
    {
        if ( this.getCredits() >=3)
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
        super.updateCompanyCard();
    }
    
    /** @overrides which overrides toString() in Card to include subclass data
     * Method returning a string representation of Company Card with all details,
     */ 
    public String toString()
        {
            String s;
            //call to parent class
            s = super.toString();
            return s;
            
        }
    
}
