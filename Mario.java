package mario;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;


/*Date:  4-1-2015
*By:  Kevin Wilson
*Pset4 problem for Java launchCode class
*program generates 1-half of a pyramid populated with a keyboard sign that will be selected by the user at run time.
*It will be printed to either the console or to a text file depending on user input also at runtime.
*
*/

public class Mario {

    public static void main(String[] varArgs) {
        boolean continueMario = true;
        System.out.println("\n  ! The Pyramid Program !\n");
        System.out.println("   Half pyramid populated with keyboard symbols selected by the user.");
        System.out.println("   User also gets to select the print option.\n");

        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        // display the symbol options listed in the symbolmap bean
        PyramidSymbols pyramidsymbols = (PyramidSymbols) context.getBean("symbols");
        pyramidsymbols.displayAll();
        System.out.println("\nEnter a Symbol  ");
        Scanner symbolInput = new Scanner(System.in);
        String strS = symbolInput.nextLine();
        System.out.println("Symbol entered is:  " + strS);

        // perform a search to check for valid symbol key
        Map<String, String>tmpSMap = pyramidsymbols.getSymbolMap();
        if (!tmpSMap.containsKey(strS)) {
            System.out.println("\n !!! Input Symbol selection not available. ");
            continueMario = false;
        }

        // display print options listed in the printmap bean
        if (continueMario) {
           PrintOptions printoptions = (PrintOptions) context.getBean("printout");
           printoptions.displayAll();
           System.out.println("\nEnter a numeric option:  ");
           Scanner printInput = new Scanner(System.in);
           int i = printInput.nextInt();
           String strI = Integer.toString(i);

           // perform a search to check for valid print key
           Map<String, String>tmpPMap = printoptions.getPrintMap();
           if (!tmpPMap.containsKey(strI)) {
                System.out.println("\n !!! Input Print selection not available. ");
                continueMario = false;
           }

            // create an instance object for printing the pyramid
            if (continueMario) {
                String printVal = tmpPMap.get(strI);
                Pyramid makePyramid = PyramidTypeFactory.makePyramidType(strS);
                PrintStrategy printStrategy = (PrintStrategy) context.getBean(printVal);
                printStrategy.print(makePyramid);
            }
        }
    }
}    //closes class Mario
