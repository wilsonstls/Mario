package mario;
import java.io.*;
/**
*1/22/15
*generates an object string of a Pyramid shape using an abstract method. 
*/

public abstract class Pyramid 
{  
      public abstract String pyramidCharacter();    
  
      public String toString(String keysign)    
       {
         int high =10;       // hard coded for height of 10 rows
         int ht, indx, r, s; 
         StringBuilder sb = new StringBuilder();
         for (r = high; r > 0; r--)                // loop to generate num of rows for height
         {indx = 0;        
            for (s = 1; s < r; s++)               // first print blank spaces on a line
             {
               sb.append(" ");
               indx = s;                           // set index holder where spaces on line end
             }
              for (ht = indx; ht < high; ht++)    // begin printing (sign) to fill in rest of the line
              {              
                 sb.append(keysign);
              }       
            sb.append("\n");        // line break
          }  
         return sb.toString();
       }  

      @Override
      public String toString()
      {
          return toString(pyramidCharacter());
      }

}   // close abstract class

