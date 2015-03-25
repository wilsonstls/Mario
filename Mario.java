package mario;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.util.Map.Entry;

/*Date:  3-11-2015
*By:  Kevin Wilson
*Pset4 problem for Java launchCode class
*program generates 1-half of a pyramid populated with a keyboard sign that will be selected by the user at run time.
*It will be printed to either the console or to a text file depending on user input also at runtime.
*
*/

public class Mario
{

    public static void main(String[] varArgs) {
        System.out.println("\n  ! The Pyramid Program !\n");
        System.out.println("   A half pyramid populated with a keyboard symbol will be generated.");
        System.out.println("   User gets to select printout option.\n");

        // retrieve the Symbol character from Symbols Bean
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        PyramidSymbols pyramidsymbols = (PyramidSymbols) context.getBean("symbols");
        pyramidsymbols.display();

        // pass the Symbol from the getter method in PyramidSymbols.java into object sT
        String sT = pyramidsymbols.getSymbolType();

        // display printout options from printout bean
        PrintOptions printoptions = (PrintOptions) context.getBean("printout");
        printoptions.display();

        System.out.println("\nEnter a numeric option:  ");
        Scanner userInput = new Scanner(System.in);
        int selPrint = userInput.nextInt();
        // if (selPrint != 1 && selPrint != 2)
        //     throw new IllegalArgumentException(" Input Error - Invalid Print Selection !!");

        //convert the input primitive data type to object Integer using wrapper
        Integer sP = new Integer(selPrint);

        // retrieve print Map and store in tmpMap to create a HashMap
        Map tmpMap = printoptions.getPrintMap();

        // use a hashmap for converting Object to Integer can then compare Key to input Integer
        Set<Entry<Integer, String>> tM = tmpMap.entrySet();
        Iterator mT = tM.iterator();
        while (mT.hasNext()) {
            Map.Entry mE = (Map.Entry) mT.next();     /** entries are of Object type */
            String tmpI = (String) mE.getKey();  /** cast Object Key to String type */
            int i = Integer.parseInt(tmpI);      /** cast String Key to Int    type */
            if (i == sP) {
                System.out.println("Print option:  " + mE.getKey() + " - " + mE.getValue());
                Pyramid makePyramid = PyramidTypeFactory.makePyramidType(sT);
                switch(i) {
                    case 1:
                        ConsolePrint.print(makePyramid);
                        break;
                    case 2:
                        FilePrint.print(makePyramid);
                        break;
                    default:
                        System.out.println("\n!! ERROR while creating output");
                }

            }
        }
    }   //closes main
}    //closes class Mario

     