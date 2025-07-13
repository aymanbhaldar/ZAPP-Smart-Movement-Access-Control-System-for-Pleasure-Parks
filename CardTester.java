import java.util.Scanner;
 

  
/**
 * Write a description of class CardTester here.
 *
 *@author Ayman A. Bhaldar 
 * @version 11/1/24
 */
public class CardTester
{
    public static void main(String[] args)
    {
        Card c1;
        c1= new Card(123, "Ayman", 10, 20);
        String cs = c1.toString();
        System.out.println(cs);
        
        //Print Id Number of the card
        int id = c1.getIdNumber();
        System.out.println("\nThe Id Number for c1\n" + "\n is: " + id);
        
        //Print Name of the Card Owner
        String name = c1.getName();
        System.out.println("\nThe Name for c1\n"  + "\n is: " + name);
        
        //Print the Luxury Rating of the card
        int lux = c1.getLuxRating();
        System.out.println("\nThe Luxury Rating for c1\n"  + "\n is: " + lux);
        
        //Print the amount of credits on the card
        System.out.println("\nThe credits for c1\n"  + "\n is: " + c1.getCredits());
        
        //Print the amount of points on the card
        System.out.println("\nThe points for c1\n"  + "\n is: " + c1.getPoints());
        
        //Add credits to the card and give details of the card
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the credits to add: " );
        int credit = sc.nextInt();
        c1.addCredits(credit);
        System.out.println(c1.toString());
        
        //Check if guest has enough credits on the card to cross bridge
        System.out.println("Does guest has enough credits? : " + c1.hasCredits() );
        
        // Moving card across bridge multiple times to get 4 point to convert to creedit later
        c1.updateCard();
        System.out.println("The amount of credits & points left after crossing the bridge on your card is: "
                            + c1.getCredits() + "&" + c1.getPoints() );
        c1.updateCard();
        System.out.println("The amount of credits & points left on your card is: " 
                            + c1.getCredits() + "&" + c1.getPoints());
        c1.updateCard();
        System.out.println("The amount of credits & points left on your card is: " 
                            + c1.getCredits() + "&" + c1.getPoints());
        c1.updateCard();
        System.out.println("The amount of credits & points left on your card is: " 
                            + c1.getCredits() + "&" + c1.getPoints());
        c1.updateCard();
        System.out.println("The amount of credits & points left on your card is: " 
                            + c1.getCredits() + "&" + c1.getPoints());
        
        //Converting point to Credits on the card
        c1.convertPointsToCredits();
        System.out.println("You have converted 4 point to 1 credit!");
        System.out.println("The amount of credits left on your card is: " + c1.getCredits());
       
    }
        
    
}
