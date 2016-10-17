package imkn.iterator;

import java.util.Collection;


public class IteratorExampleJDK5 {

    private static void iterate(Collection<String> coll) {

        // эта конструкция разворачивается ровно в тот while с итератором

        for (String s: coll) {
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
