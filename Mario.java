package mario;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;
/*Date:  2-11-2015
*By:  Kevin Wilson
*Pset3 problem for Java launchCode class - demonstrate the Singleton Design Pattern
*program generates 1-half of a pyramid populated with a keyboard sign that will be selected by the user at run time.
*It will be printed to either the console or to a text file depending on user input also at runtime.
*
*/

public class Mario
{

    public static void main(String[] varArgs) 
    {  
        System.out.println("\n  ! The Pyramid Program !\n"); 
        System.out.println("\n  Filled with keyboard symbols the user gets to select.\n");   
    
          // request user input
        Scanner userInput = new Scanner(System.in);   
        System.out.println("\n  which symbol?  %  or  #  ");   
        String symbolInput = userInput.nextLine();

        System.out.println("\n To print pyramid to the console screen enter  1 ");
        System.out.println("\n To print pyramid to a text file enter  2 \n");
        int selPrint = userInput.nextInt();
        if (selPrint != 1 && selPrint != 2)
          throw new IllegalArgumentException(" Input Error - Invalid Print Selection !!");
             PrintStrategy printstrategy1 = new ConsolePrint();   
             PrintStrategy printstrategy2 = new FilePrint();

        
        /* testing for a single instance using interface injection */
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        PyramidTypeFactory testMessage1 = (PyramidTypeFactory) context.getBean("testInstance");
        testMessage1.setMessage("the 1st instance");
        System.out.println("The 1st test should return:  " + testMessage1.getMessage());
        PyramidTypeFactory testMessage2 = (PyramidTypeFactory) context.getBean("testInstance");
        // run test again, new object should return same message the 1st object did
        testMessage2.getMessage();
        System.out.println("The 2nd test should return:  " + testMessage2.getMessage());

        PyramidTypeFactory typeFactory = new PyramidTypeFactory();
        Pyramid makePyramid = typeFactory.makePyramidType(symbolInput);     // input symbol is sent to the Factory which decides which subclass
        // subclass return value is then sent to makePyramid object

        if (selPrint == 2)
        { printstrategy2.print(makePyramid);                        // pyramid is generated using the value in makePyramid
        }  else
            printstrategy1.print(makePyramid);


    }   //closes main
}    //closes class Mario
     