package imkn.fmr;

import imkn.iterator.IteratorCollectionHolder;

import java.util.ArrayList;
import java.util.List;


public class FMR_JDK5 {

    public static void main(String[] args) {
        List<String> list = IteratorCollectionHolder.getList();
        printList("init", list);

        List<String> filteredList = filter(list);
        printList("filter", filteredList);

        List<String> mappedList = map(filteredList);
        printList("map", mappedList);

        int sumLength1 = reduce(mappedList);
        System.out.println(sumLength1);

        // all operations
        int sumLength2 = reduce(map(filter(list)));
        System.out.println(sumLength2);
    }

    // help method
    private static void printList(String msg, List<String> list) {
        System.out.println(msg);
        for (String s: list) {
            System.out.println(s);
        }
        System.out.println();
    }

    private static List<String> filter(List<String> list) {
        List<String> newColl = new ArrayList<>();
        for (String s: list) {
            if (!s.endsWith("2")) { // filter
                newColl.add(s);
            }
        }
        return newColl;
    }

    private static List<String> map(List<String> list) {
        List<String> newColl = new ArrayList<>();
        for (String s: list) {
            s = s + "_123"; // map
            newColl.add(s);
        }
        return newColl;
    }

    private static int reduce(List<String> list) {
        int sumLength = 0;
        for (String s: list) {
            sumLength += s.length(); // reduce
        }
        return sumLength;
    }

}
