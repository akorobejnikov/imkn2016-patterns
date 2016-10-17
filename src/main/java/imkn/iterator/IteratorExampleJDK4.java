package imkn.iterator;

import java.util.Collection;
import java.util.Iterator;

public class IteratorExampleJDK4 {

    private static void iterate(Collection<String> coll) {
        Iterator<String> i = coll.iterator();
        while (i.hasNext()) {
            String s = i.next();
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        iterate(IteratorCollectionHolder.getCollection(1));
        iterate(IteratorCollectionHolder.getCollection(2));
        iterate(IteratorCollectionHolder.getCollection(3));
        iterate(IteratorCollectionHolder.getCollection(4));
    }
}
