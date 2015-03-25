package mario;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.Set;
/**
*3/11/15
*Printing options injected by Spring Map collections.
*/

public class PrintOptions {

    private Map printMap;
    public void setPrintMap(Map printMap) {
        this.printMap = printMap;
    }

    public Map getPrintMap() {
        return printMap;
    }
    

    public void display() {

        System.out.println("\n Here are your printing options \n");
        Set<Entry<Integer, String>> K = printMap.entrySet();
        Iterator iT = K.iterator();
        while (iT.hasNext()) {
            Map.Entry mE = (Map.Entry) iT.next();
            System.out.println("Print option:  " + mE.getKey() + " - " + mE.getValue());
        }

    }

}



