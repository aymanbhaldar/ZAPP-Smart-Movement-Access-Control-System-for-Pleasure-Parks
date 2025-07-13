import java.util.*;
import java.util.ArrayList;
/**
 * A Area is part of a ZAPP resort.Each area has a name,  a luxury rating
 * and a capacity which represents the maximum number of people(cards) who can be on the  
 * area at any one time. Each area must maintain a list of all people (cards)
 * currently on the area. These lists are updated whenever cards enter or leave 
 * an area,so that it is always possible to say how many people (cards) are in the area 
 * and who they are.
 * 
 * @author Ayman A. Bhaldar 
 * @version 11/1/24
 */


public class Area 
{
    private int referenceNo;
    private String name;
    private int rating;
    private int capacity;
    
    private ArrayList<Card> cardList;
    
    /** Creates an area
     * @param refNo represents the area's reference number
     * @param n represents the area's name
     * @param r represents the luxury rating
     * @param cap represents the capacity
     */
    public Area(int refNo, String n, int r, int cap)
    {
        referenceNo = refNo;
        name = n;
        rating = r;
        capacity = cap;
        cardList = new ArrayList<Card>(); 
    }
    
    /** Returns Area's reference number
     * @return area reference number
     */
    public int getReferenceNo()
    {
        return referenceNo;
    }
    
    /** Returns Area's name
     * @return area name
     */
    public String getName()
    {
        return name;
    }
    
    /** Return's Area's luxury rating
     * @return area luxury rating
     */
    public int getRating()
    {
        return rating;
    }
    
    /** Return's Area's capacity
     * @return area capacity
     */
    public int getCapacity()
    {
        return capacity;
    }
    
    /** Method to return a string representation of area details and a list of the Cards in the area
     * 
     */
    public String toString()
    {
        return("\n" + referenceNo + "\n" + " " + name + "\nRating: " + rating + "\nCapacity: " + capacity + "\n******CardList***" + getCardList() );
    }
    
    /** Return the number of cards in the area
     * 
     */
    public int noOfCards()
    {
        return cardList.size();
    }
    
    /** Method returning boolean true,
     * if a car can enter Area with enough credits & luxury rating
     * @param luxRating is luxury rating of the card
     * @param credits is credits on the card
     */
    public boolean canEnterArea(int luxRating, int credits)
    {
        if(luxRating >=  rating && credits >= 4 )
        {
            return true;
            
        }
        else 
        {
            return false;
        }
    }
    
    /** Method to add card to destination area
     * 
     */
    public void enter(Card c)
    {
        cardList.add(c);
    }
    
    /** Method to remove card from source area
     * 
     */
    public void leave(Card c)
    {
        
        Card temp = findCardInArea(c);
        
        if(temp != null)
        {
            cardList.remove(temp);
        }
        c.updateCard();
        
    }
    
    /** Method to find one card in the area
     * @param Card c is a card
     * @return Card in the area
     */
    public Card findCardInArea(Card c)
    {
        int id = c.getIdNumber();
        for (int i=0; i<cardList.size(); i++)
        {
            Card temp = cardList.get(i);   
            if(temp.getIdNumber() == id)
            {
                return temp;
            }
        }
        return null;        
    }
    
    /** Method returning true,
     *  if card is in the area with card id number
     * @param id is the card id number
     */
    public boolean isInArea(int id)
    {
        for(int i=0; i<cardList.size(); i++)
        {
            Card temp = cardList.get(i);
            if(temp.getIdNumber()== id)
            {
                return true;
            }
        }
        return false;
    }
    
    /** Method to return a string representation of all cards in the area.
     * 
     */
    public String getCardList()
    {
        String ss = "";
        if (cardList.size()>0)
        {
            for(Card temp: cardList)
            {
                ss = ss + "\n" + temp.toString();
            }
            return ss +"\n*******************************";
        }
        return "\nNo Cards" + "\n*******************************";
    }
    
    /** Method returning a String representation of one card with the id number
     * @param id is the id number of the card
     */
    public String getOneCard(int id)
    {
        String ss = "";
        for(int indx=0; indx<cardList.size(); indx++)
        {
            Card temp = cardList.get(indx);
            if(temp.getIdNumber()== id)
            {
                ss = temp.toString();
            }
        
        }
        return ss;
    }
    
    /**Method returning boolean true,
     * if area capacity is full
     */
    public boolean isFull()
    {
        if (cardList.size() >= capacity)
        {
            return true;
        }
        else
        {
            return false;
        }
    } 
    
    
}
