package mario;
import java.io.*;

/**
* prints output to a text file.
*/

public class FilePrint implements PrintStrategy
{
    public void print(Pyramid pyramid)
    {
      System.out.println("\n Output is to be printed to a text file\n");
      File outfile = new File("c:/Launchcode/Mario/pyramid.txt");
      String pyramidRef;    // a reference location for the incoming pyramid string

       try (PrintWriter fP  = new PrintWriter(outfile))
        {      
           pyramidRef = pyramid.toString();
           fP.println(pyramidRef.replaceAll("\n", "\r\n"));
           System.out.println("The file:  " + outfile + "  has successfully been written\n");
        }
         catch (IOException e)
             {
               System.out.println("\n!!! There is a problem with the output file !!!" + e.getMessage());
               e.printStackTrace();
             } 
    }
}
