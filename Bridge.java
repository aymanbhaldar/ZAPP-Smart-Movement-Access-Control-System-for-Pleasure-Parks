 

  
/**
 * A bridge provides a one-way connection between two areas. It
 has a bridge code and information about both the source and
 the destination area
 * 
 * @author Ayman A. Bhaldar 
 * @version 11/1/24
 */
public class Bridge
{
    private String code;
    private Area source;
    private Area destination;
    /** Creates a bridge
     * @param cd represents the bridge code
     * @param src is the Source Area
     * @param dst is the Destination Area
     * @param cr represents the credits
     */
    public Bridge(String cd, Area src, Area dst)
    {
        code = cd;
        source = src;
        destination = dst;
    }
    
    /**Returns Bridge code
     * @return bridge code
     */
    public String getBridgeCode()
    {
        return code;
    }

    /** Method returning boolean true,
     * if specified Card can enter the destination Area
     * @param cc is the specified Card
     */
    public boolean canCardEnter(Card cc)
    {
        
            int luxRating = cc.getLuxRating();
            int idNumber = cc.getIdNumber();
            int credits = cc.getCredits();
            if(destination.canEnterArea(luxRating,credits)
            && !destination.isFull() && source.isInArea(idNumber)  ) 
            {
                return true;   
            }
            else
            {
                return false;
            }        
           
    }
    
    /**Method returning String with suitable message of the result of the request
     * Method to move card from Source Area to Destination Area
     * @param cc is the specidied Card cc
     * @return a String giving the result of the request
     */
    public String moveCard(Card cc)
    {
        int luxRating = cc.getLuxRating();
        int idNumber = cc.getIdNumber();
        int credits = cc.getCredits();
        if(!destination.canEnterArea(luxRating,credits))
        {
            return "You do not have enough Credits or Luxury Rating to enter Area. ";
        }
        else if(destination.isFull())
        {
            return "The Area is full at the moment, please try again later.";
        }
        else if (!source.isInArea(idNumber))
        {
            return "The card is not listed in the source Area.";
        }
        else
        {
            destination.enter(cc);
            source.leave(cc);
            return "Card: " + idNumber + " added to Area " + destination.getName();
            
        }
    }
        
    /** Returns a String representation of the details of the Bridge including
     * bridge code, source Area & destination Area
     * @return string with details of bridge
     */
    public String toString()
    {
        return "\nBridge Code : " + code + "\nFrom: " + source.getReferenceNo()
        + " " + source.getName() + "\nTo : " + destination.getReferenceNo()
        + " " + destination.getName();
        
    }
    
}
