package imkn.iterator;

import java.util.Collection;

public class IteratorExampleJDK8_1 {

    private static void iterate(Collection<String> coll) {

        // эта конструкция разворачивается практически(*) в тот while с итератором

        coll.forEach( s ->
            System.out.println(s)
        );
    }

    public static void main(String[] args) {
        iterate(IteratorCollectionHolder.getCollection(1));
        iterate(IteratorCollectionHolder.getCollection(2));
        iterate(IteratorCollectionHolder.getCollection(3));
        iterate(IteratorCollectionHolder.getCollection(4));
    }

}
