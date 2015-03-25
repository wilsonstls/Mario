package mario;
import java.io.*;
/**
* prints output to the screen.
*/

public class ConsolePrint
{
    static void print(Pyramid pyramid)
    {
      System.out.println("\nYou selected to print to the console screen !!\n");

      PrintWriter pw = new PrintWriter(System.out);
                  pw.println(pyramid.toString());
                  pw.flush();
                  pw.close();
    }
}
