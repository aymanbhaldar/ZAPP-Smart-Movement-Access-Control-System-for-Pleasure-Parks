
/**
 * Write a description of class TouristCard here.
 *
 * @author Ayman A. Bhaldar 
 * @version 11/1/24
 */
public class TouristCard extends Card
{
    /** Creates a Tourist card
     * @param idNumber represents the tourist card's id number
     * @param n represents the tourist's name
     * @param luxRating is the luxury rating of card
     * @param credits represents the credits
     */
    public TouristCard (int idNumber, String name, int luxRating, int credits)
    {
        super(idNumber, name, luxRating, credits);       
    }
    
    /** @overrides which overrides toString() in Card to include subclass data
     * Method returning a string representation of Tourist Card with all details,
     */ 
    public String toString()
    {
        String s;
        //call to parent class
        s = super.toString(); 
        return s;
        
    }
    
    
    
}
