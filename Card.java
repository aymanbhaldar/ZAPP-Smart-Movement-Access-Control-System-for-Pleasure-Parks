 

   
/**
 * A Card has an id number, name, a luxury rating, number of credits and points.
 * 
 * @author Ayman A. Bhaldar 
 * @version 11/1/24
 */

public class Card 
{
    private int idNumber;
    private String name;
    private int luxRating;
    private int credits;
    private int points;
    /** Creates a card
     * @param id represents the card's id number
     * @param n represents the name
     * @param lux represents the luxury rating
     * @param cr represents the credits
     */
    public Card(int id, String n, int lux, int cr)
    {
        idNumber = id;
        name = n;
        luxRating = lux;
        credits = cr;
        points = 0;
        
    }
    
    /**Returns card's id number
      * @return card id number 
      */
    public int getIdNumber()
    {
        return idNumber;
    }
    
    /**Returns Card Owner's Name
      *@return Card Owner Name
      */
    public String getName()
    {
        return name;
    }
    
    /**Returns points
      *@return points
      */
    public int getPoints()
    {
        return points;
    }
    
    /**Returns Luxury Rating between 1-10
      *@return Luxury Rating
      */
    public int getLuxRating()
    {
        if (luxRating>0 && luxRating<=10  )
        {
            return luxRating;
        }
        else
        {
            return 0;
        }
        
    }
    
    /**Returns Credits
      *@return Credits
      */
    public int getCredits()
    {
        return credits;
    }
    
    /** Method to update credits and points when a card uses a bridge 
      */
    public void addCredits(int cr)
    {
        credits += cr;
    }
    
    /** Method returning boolean true,
      * if the card has enough credits for a bridge crossing 
      */
    public boolean hasCredits()
    {
        if ( credits >=4)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    /** Method to add or deduct credits
     * 
     */
    public void updateCard()
    {
        credits = credits - 4;
        points = points + 1;
        
    }
    
    /** Methods to add or deduct credits for Child Card
     * 
     */
    public void updateChildCard()
    {
        credits = credits;
        points = points +1;
        
    }
    
    /** Methods to add or deduct credits for Company Card
     * 
     */
    public void updateCompanyCard()
    {
        credits = credits - 3;
        points = points + 2;
    }
    
    /** Method to convert points to credits
     * 
     */
    public void convertPointsToCredits()
    {
        if (points >=3)
        {
            credits = credits + 1;
            points = points - 3;
        }
        
        else
        {
            System.out.println("You do not have enough point to convert.");
        }
    }
    //another method for childCard & companyCard
    public void setCreditsAndPoints(int credits, int points)
    {
        credits=credits;
        points = points;
    }
    
    /** Method returning a String with all  relevant information about the Card
     * 
     */
    public String toString()
    {
        String s;
        s = "\nCard ID Number: " + idNumber +
        "\nName: " + name + "\nLuxury Rating: "
        + luxRating + "\nCredits Available: " 
        + credits + "\nPoints Available: " + points;
        return s;
    }
    
    
    
}

