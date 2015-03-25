package mario;
/**
*3/11/15
* Getter and Setter methods for the keyboard symbol type
*/

public class PyramidSymbols {

     private String symboltype;

     public String getSymbolType() {
        return symboltype;
     }

     public void setSymboltype (String symboltype) {
         this.symboltype = symboltype;
         }


     void display(){
         System.out.println(" Keyboard Symbol: " +getSymbolType());
     }

}
