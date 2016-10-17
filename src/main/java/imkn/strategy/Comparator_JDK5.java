package imkn.strategy;


import imkn.iterator.IteratorCollectionHolder;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparator_JDK5 {

    private static void print(String msg, List<String> list) {
        System.out.println("\n" + msg);
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {

        List<String> list = IteratorCollectionHolder.getList();

        print("init", list);

        // natural ordering
        Collections.sort(list);
        print("natural ordering", list);

        // reversed comparator
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        print("reversed comparator", list);

        // by last char comparator
        Collections.sort(list, new Comparator<String>() {

            private Character lastChar(String s) {
                return s.charAt(s.length() - 1);
            }

            @Override
            public int compare(String o1, String o2) {
                return lastChar(o1).compareTo(lastChar(o2));
            }
        });
        print("last char comparator", list);
    }

}
