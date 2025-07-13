 

  
import java.util.Scanner;
import java.util.*;
/**
 * Write a description of class ParkUI here.
 * 
 * @author Ayman A. Bhaldar 
 * @version 11/1/24
 */
public class ParkUI
{
    
    private Scanner reader = new Scanner(System.in);
    private ZAPP fantasia = new Park("Wayward Asteroids");
    
    private void runUI()
    {   

        int choice = getOption();        
        while (choice != 0)
        {            
            // process choice
            if      (choice == 1){listAllAreas();}
            else if (choice == 2){listAllCards();}
            else if (choice == 3){listOneArea();}
            else if (choice == 4){findCardLocation();}
            else if (choice == 5){tryTravel();}
            else if (choice == 6){moveNow();}
            else if (choice == 7){updateCredits();}
            else if (choice == 8){convertPoints();}
            else if (choice == 9){getCardInfo();}
            // output menu & get choice
            choice = getOption();
        }
        System.out.println("\nThank-you");
    }
    
    
    private int getOption()
    {
       System.out.println("What would you like to do ?");
       System.out.println("0. Quit");
       System.out.println("1. List all area details");
       System.out.println("2. List all cards on each area");
       System.out.println("3. List all cards on one area");
       System.out.println("4. Find card location");
       System.out.println("5. Say if card can move by bridge");
       System.out.println("6. Move a card by bridge");
       System.out.println("7. Top up credits");
       System.out.println("8. Convert Points to Credits");
       System.out.println("9. Get card details");

       System.out.println("Enter your choice");
       // read choice
       int option = reader.nextInt();
       reader.nextLine();
       return option;
    }
    
    // This one has been done for you 
    private void listAllAreas()
    {
        System.out.println(fantasia.toString());
    }
    
    // provide the code here  
    private void listAllCards()
    {
        System.out.println(fantasia.getAllCardsInAllAreas());
        
    }
   
    // This one has been done for you 
    private void listOneArea()
    {
        System.out.println("Enter name of area");
        String ww = reader.nextLine();
        System.out.println(fantasia.getAllCardsInOneArea(ww));
    }
    
    // provide the code here
    private void findCardLocation()
    {
        System.out.println("Enter the Card Id Number: ");
        int id = reader.nextInt();
        System.out.println(fantasia.getCardLocation(id));
        
        
    }
    
    // This one has been done for you 
    private void tryTravel()
    {
        System.out.println("Enter card id");
        int trav = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter bridge code");
        String bridge = reader.nextLine();
        System.out.println(fantasia.canMove(trav,bridge));
    }
    
    // Provide the code here
    private void moveNow()
    {
        System.out.println("Enter card id");
        int id = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter bridge code");
        String code = reader.nextLine();
        System.out.println(fantasia.move(id ,code ));
    }
    
    // provide the code here
    private void updateCredits()
    {
        System.out.println("Enter card id");
        int id = reader.nextInt();
        System.out.println("Enter amount of credits you want to add");
        int creds = reader.nextInt();
        fantasia.topUpCredits( id, creds);
        System.out.println(fantasia.getCardDetails(id));
        
    }
    
    private void convertPoints()
    {
        System.out.println("Enter card id");
        int id = reader.nextInt();
        fantasia.convertPoints(id);
        System.out.println(fantasia.getCardDetails(id));        
    }
    
    private void getCardInfo()
    {
        System.out.println("Enter card id");
        int trav = reader.nextInt();
        System.out.println(fantasia.getCardDetails(trav));
    }
   
    
    public static void main(String[] args)
    {
        ParkUI xx = new ParkUI();
        xx.runUI();
    }
}
