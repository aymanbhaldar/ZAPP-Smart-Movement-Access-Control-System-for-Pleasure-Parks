import java.util.*;
/**
 * Write a description of class MyTester here.
 * 
 * @author Ayman A. Bhaldar 
 * @version 11/1/24
 */
public class MyTester 
{   
    
    private void doTest()
    {
        ZAPP fantasia = new Park("Fantasia Pleasure Park");        
        
        //Find all Cards
        System.out.print("********** Cards *******");
        System.out.println(fantasia.getAllCardsInAllAreas());
        
        //Find All Areas
        System.out.print("********** Areas *******");
        System.out.println(fantasia.toString());
        
        //Find All Cards in One Area
        System.out.print("********** Cards in One Area *******");
        System.out.println(fantasia.getAllCardsInOneArea("Concourse"));
        
        // Find Location of Card
        System.out.print("********** Find Card Location *******");
        System.out.println(fantasia.getCardLocation(1000));
        
        //Can Card move to New Area?
        System.out.print("********** Can Card Move to new Area?*******");
        System.out.println(fantasia.canMove(1002,"DEF4"));
        
        //Moving Card to New Area
        System.out.print("********** Move Card to New Area. *******");
        System.out.println(fantasia.move(1002,"ABC1" ));
        
        //Topup Card with Credits
        System.out.print("********** Topup Card. *******");
        fantasia.topUpCredits( 1002, 10);
        System.out.println(fantasia.getCardDetails(1002));
        
        //Convert points to credit
        System.out.print("********** Topup Card. *******");
        fantasia.convertPoints(1002);
        System.out.println(fantasia.getCardDetails(1002));
        
        //Get Card Details
        System.out.print("********** Get Details of Card *******");
        System.out.println(fantasia.getCardDetails(1002));
        
        
     }
     
     
    
    public static void main(String[] args)
    {
        MyTester xx = new MyTester();
        xx.doTest();
    }
}
