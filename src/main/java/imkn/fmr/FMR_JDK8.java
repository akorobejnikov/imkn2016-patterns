package imkn.fmr;


import imkn.iterator.IteratorCollectionHolder;

import java.util.List;
import java.util.stream.Collectors;

public class FMR_JDK8 {

    private static void printList(String msg, List<String> list) {
        System.out.println(msg);
        list.forEach(System.out::println);
        System.out.println();
    }

    public static void main(String[] args) {
        List<String> list = IteratorCollectionHolder.getList();
        printList("init", list);

        List<String> filteredList = list.stream().filter(s -> !s.endsWith("2")).collect(Collectors.toList());
        printList("filter", filteredList);

        List<String> mappedList = filteredList.stream().map(s -> s + "_123").collect(Collectors.toList());
        printList("map", mappedList);

        int sumLength1 = mappedList.stream().map(String::length).reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(sumLength1);

        int sumLength2 = list.stream()
            .filter(s -> !s.endsWith("2"))
            .mapToInt(s -> (s + "_123").length())
            .sum();
        System.out.println(sumLength2);

        // примечание: здесь можно было бы сделать через коллекторы - это для самостоятельного изучения

    }

}
