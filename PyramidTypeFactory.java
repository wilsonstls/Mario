package mario;
/**
*2/11/15
*Factory design pattern implementation that instantiates Pyramid object 
*/

public class PyramidTypeFactory {

   static Pyramid makePyramidType(String pyramidType)
   {
      if (pyramidType.equals("%")) {

          return new PercentSignPyramid();

      } else if (pyramidType.equals("#")) {

               return new PoundSignPyramid();

      } else 

          throw new IllegalArgumentException(" Input Error - Not one of the available symbols!!");
   }

}

