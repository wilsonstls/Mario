package mario;

import java.util.Map;
import java.util.Set;

/**
*3/11/15
* Getter and Setter methods for the keyboard symbol type
*/

public class PyramidSymbols {

    private Map symbolMap;

    public void setSymbolMap(Map symbolMap) {

        this.symbolMap = symbolMap;
    }

    public Map getSymbolMap() {
        return symbolMap;
    }

    public void displayAll() {

        System.out.println("\n Here are the Symbol options \n");

        Set<Map.Entry<String, String>> smap = symbolMap.entrySet();
        for (Map.Entry<String, String> mE : smap) {
            System.out.println("Symbol option:  " + mE.getKey());
        }
    }
}
