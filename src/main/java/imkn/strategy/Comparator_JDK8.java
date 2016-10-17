package imkn.strategy;


import imkn.iterator.IteratorCollectionHolder;

import java.util.List;
import java.util.stream.Collectors;

public class Comparator_JDK8 {

    private static void print(String msg, List<String> list) {
        System.out.println("\n" + msg);
        list.forEach(System.out::println);
    }

    private static Character lastChar(String s) {
        return s.charAt(s.length() - 1);
    }

    public static void main(String[] args) {

        List<String> list = IteratorCollectionHolder.getList();

        print("init", list);

        // natural ordering
        list = list.stream().sorted().collect(Collectors.toList());
        print("natural ordering", list);

        // reversed comparator
        list = list.stream().sorted((o1, o2) -> -o1.compareTo(o2)).collect(Collectors.toList());
        print("reversed comparator", list);

        // by last char comparator
        list = list.stream().sorted((o1, o2) -> lastChar(o1).compareTo(lastChar(o2))).collect(Collectors.toList());
        print("last char comparator", list);

    }
}
