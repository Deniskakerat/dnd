package DataVisitor;

import java.util.TreeMap;

public interface  DataElement {
    TreeMap<Object,Object> accept(DataElementsVisitor elementsVisitor);
}
