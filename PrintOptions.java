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

    public void displayAll() {

        System.out.println("\n Here are your printing options \n");

        Set<Map.Entry<String, String>> pmap = printMap.entrySet();
        for (Entry<String, String> mE : pmap) {
            System.out.println("Print option:  " + mE.getKey() + " - " + mE.getValue());
        }

    }

}

