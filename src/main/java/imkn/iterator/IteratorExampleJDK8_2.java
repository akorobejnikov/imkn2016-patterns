package imkn.iterator;

import java.util.Collection;
import java.util.stream.IntStream;


public class IteratorExampleJDK8_2 {

    private static void iterate(Collection<String> coll) {

        // эта конструкция разворачивается практически(*) в тот while с итератором
        coll.forEach(System.out::println);
    }

    public static void main(String[] args) {

        IntStream.rangeClosed(1, 4).forEach( i ->
            iterate(IteratorCollectionHolder.getCollection(i))
        );

    }

}
