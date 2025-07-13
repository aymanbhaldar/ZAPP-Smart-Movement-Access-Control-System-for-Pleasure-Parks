 
import java.util.*;


/**This class implements the ZAPP interface
 *
 * @author Ayman A. Bhaldar 
 * @version 11/1/24
 **/
public class Park implements ZAPP
{
    private ArrayList<Card> allCard = new ArrayList<Card>();
    private ArrayList<Area> allArea = new ArrayList<Area>();
    private ArrayList<Bridge> allBridge = new ArrayList<Bridge>();
    private String parkName;

    /** constructor
     */
    public Park(String nme) 
    {
        parkName = nme;
        loadAreas();
        setupBridge();
        loadCards();
        addCardsToLobby();
        
    }
    
    /**
     * Returns all of the details of the park: its name and its areas 
     * including lists of cards in each area.
     */
    public String toString()
    {
        String ss = parkName;
        ss = ss + getAllCardsInAllAreas()+ getAllAreas();
        return ss;
    }
    

    /**Returns the number of cards registered in the Park.
     *@return number of cards 
     */
    public int noOfCards()
    {
        return allCard.size();
    }
    
    /**Returns a String with details of a card
     * @param id - id number of the card
     * @return the details of the card as a String, or "No such card"
     */
    public String getCardDetails(int id)
    {
        for (Card temp : allCard)
        {
            if(temp.getIdNumber() == id)
            {
                return temp.toString();
            }
        }
        return "No such card";
    } 
    
    /**Returns the name of the area which contains the specified card or null
     * @param id - id number of the specified card
     * @return the name of the Area which contains the card, or null
     **/
    public String getCardLocation(int id)
    {
        
        Card temp = findCard(id);
        if (temp != null)
        {
            for (Area atemp : allArea)
            {
                if(atemp.isInArea(id))
                {
                    return "The location of the card is: " + atemp.getName();
                }
                
            }
        }
        return null;
    }
    
    /** Given the name of a area, returns the area id number
     * or -1 if area does not exist
     * @param ww is name of area
     * @return id number of area
     */
    public int getAreaNumber(String ww)
    {
        for (Area temp: allArea)
        {
            if(temp.getName() == ww)
            {
                return temp.getReferenceNo();
            }
        }
        return -1;
    }
                
    /**Returns a String representation of all the cards on specified area
     * @param a is the name of the area 
     * @return a String representation of all cards on specified area
     **/
    public String getAllCardsInOneArea(String a)
    {
        
        for(Area temp: allArea)
        
        {
            
            if(a.equals(temp.getName()))
            {
                return temp.toString();
            }
        }
       
        return "No such Area";
    } 

    /**Returns a String representation of all the cards in all areas including the name of each area
     * @return a String representation of all cards on specified area
     **/
    public String getAllCardsInAllAreas()
    {
        String ss = "";
        for (int i = 0; i< allCard.size(); i++)
        {
            Card temp= allCard.get(i);
            ss = ss + "\n" + temp.toString();
        }      
        return ss;
    }
        
    /**Returns a String representation of all areas 
     * return string with details of all areas 
     */
    public String getAllAreas()
    {
        String ss = "";
        for (int i = 0; i< allArea.size(); i++)
        {
            Area temp = allArea.get(i);
            ss = ss + "\n" + temp.toString();
        }
        return ss;
    }

    
    /**Returns true if a Card is allowed to move using the bridge, false otherwise
     * A move can be made if:  
     * the rating of the card  >= the rating of the destination area
     * AND the destination area is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source area
     * AND the card id is for a card on the system
     * AND the bridge code is the code for a bridge on the system
     * @param id is the id of the card requesting the move
     * @param code is the code of the bridge by which the card wants to move
     * @return true if the card is allowed on the bridge journey, false otherwise 
    **/
    public boolean canMove(int id, String code)
    {
        Card c = findCard(id);
        Bridge b = findBridge(code);
        
        if( c == null || b == null)
        {
            return false;
        }
        else
            if (b.canCardEnter(c))
            {
                return true;
            }
            else
            {
                return false;
            }
        
        

    }     

    /**Returns the result of a card requesting to move over a bridge.
     * A move will be successful if:  
     * the luxury rating of the card  >= the luxury rating of the destination area
     * AND the destination area is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source area
     * AND the card id is for a card in the system
     * AND the bridge code is the code for a bridge on the system
     * If the bridge crossing can be made, the card information is removed from 
     * the source area, added to the destination area, card details updated and a suitable message returned.
     * a suitable message returned.
     * If bridge journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param id is the id of the card requesting the move
     * @param code is the code of the bridge by which the card wants to move
     * @return a String giving the result of the request 
     **/
    public String move(int id, String code )
    {   //other checks optional
        Card c = findCard(id);
        Bridge b = findBridge(code);
        if( c == null) 
        {
            return "Card not in the system.";
        }
        else if (b == null)
        {
            return "Bridge not in system";
        }
        else
        {
            
            return b.moveCard(c);
        }
    }     

    /** Allows a card to top up their credits.This method is not concerned with 
     *  the cost of a credit as currency and prices may vary between resorts.
     *  @param id the id of the card toping up their credits
     *  @param cr the number of credits purchased to be added to cards information
     */
    public void topUpCredits(int id, int cr)
    {
        for (Card temp: allCard)
        {
            if(temp.getIdNumber() == id)
            {
                temp.addCredits(cr);
            }
        }
        
        
    }
    
    /** Allows a card to convert points to credits
     *  @param id the id of the card toping up their credits
     */
    public void convertPoints(int id)
    {
        for (Card temp: allCard)
        {
            if(temp.getIdNumber() == id)
            {
                temp.convertPointsToCredits();
            }
        }
    }
    
    
   
    //***************private methods**************
    /**creates all the areas 
    ** and adds them to the collection of areas.  */
    private void loadAreas()
    {
        Area a0= new Area(0000, "Lobby", 0, 1000);
        allArea.add(a0);
        Area a1 = new Area(9999, "Concourse", 1, 100);
        allArea.add(a1);
        Area a2 = new Area(8888, "Waterworld", 3, 10);
        allArea.add(a2);
        Area a3 = new Area(7777, "WildWest", 5, 2);
        allArea.add(a3);
        Area a4 = new Area(6666, "Solitare", 1, 1);
        allArea.add(a4);
    }
    
    /**Creates all bridges carding area objects to their constructors,
     * then adding them to the collection of bridges. */
    private void setupBridge()
    {
            
            Bridge b1 = new Bridge("ABC1",findArea(0000),findArea(9999));
            allBridge.add(b1);
            allBridge.add(new Bridge("BCD2",findArea(9999),findArea(0000)));
            allBridge.add(new Bridge("CDE3",findArea(9999),findArea(8888)));
            allBridge.add(new Bridge("DEF4",findArea(8888),findArea(9999)));
            allBridge.add(new Bridge("JKL8",findArea(8888),findArea(7777)));
            allBridge.add(new Bridge("EFG5",findArea(7777),findArea(9999)));
            allBridge.add(new Bridge("GHJ6",findArea(9999),findArea(6666)));
            allBridge.add(new Bridge("HJK7",findArea(6666),findArea(9999)));
            
    }
    
    /**Creates all cardes and 
     * add them to the collection of cards. */
    private void loadCards()
    {
        Card c1 = new Card(1000, "Lynn", 5, 10);
        allCard.add(c1);
        Card c2 = new Card(1001, "May", 3, 20);
        allCard.add(c2);
        Card c3 = new Card(1002, "Nils", 10, 20);
        allCard.add(c3);
        Card c4 = new Card(1003, "Olek", 2, 12);
        allCard.add(c4);
        Card c5 = new Card(1004, "Pan", 3, 4);
        allCard.add(c5);
        Card c6 = new Card(1005, "Quin", 1, 5);
        allCard.add(c6);
        Card c7 = new Card(1006, "Raj", 10, 20);
        allCard.add(c7);
        Card c8 = new Card(1007, "Sol", 7, 24);
        allCard.add(c8);
        Card c9 = new Card(1008, "Tel", 6, 10);
        allCard.add(c9);
        TouristCard t1 = new TouristCard(2001, "Bob", 8, 26);
        allCard.add(t1);
        TouristCard t2 = new TouristCard(2002, "Bro", 6, 36);
        allCard.add(t2);
        ChildCard t3 = new ChildCard(3001, 3301, 0, "Lynn", 20);
        allCard.add(t3);
        ChildCard t4 = new ChildCard(3002,  3302, 0, "Chris", 15);
        allCard.add(t4);
        CompanyCard t5 = new CompanyCard(4001, "Google", 8);
        allCard.add(t5);
        CompanyCard t6 = new CompanyCard(4002, "Apple", 9);
        allCard.add(t6);
    }
    
    /**Method adds all of the cards to the “Lobby”area.
     */ 
    public void addCardsToLobby()
    {
            
            Area temp = allArea.get(0);
            for(Card tempC : allCard)
            {
                temp.enter(tempC);
            }
            
            
    }
 
    /** Returns the card with the card id specified by the parameter
     * @return the card with the specified id
     **/
    private Card findCard(int id)
    {
        for(int i = 0; i<allCard.size();i++)
        {
            Card temp = allCard.get(i);
            if (temp.getIdNumber() == id)
            {
                return temp;
            }
        }
        return null;
    }
    
    /** Returns the area with the name specified by the parameter
     * @return the area with the specified name
     **/
    private Area findArea(int refNo)
    {
        for(int i = 0; i<allArea.size();i++)
        {
            Area temp = allArea.get(i);
            if (temp.getReferenceNo() == refNo)
            {
                return temp;
            }
        }
        return null;
    }
    
    /** Returns the area with the name specified by the parameter
     * @return the area with the specified name
     **/
    private Bridge findBridge(String code)
    {
        for(int i = 0; i<allBridge.size();i++)
        {
            Bridge temp = allBridge.get(i);
            if(code.equals(temp.getBridgeCode()))
            {
                return temp;
            }
        }
        return null;
    }
       
}