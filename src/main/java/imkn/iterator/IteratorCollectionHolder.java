package imkn.iterator;

import java.util.*;

/**
 * Singleton!
 */
public class IteratorCollectionHolder {

    // private constructor
    private IteratorCollectionHolder() {}

    private static List<String> arrayList = new ArrayList<>();
    static {
        arrayList.add("brray_list_1");
        arrayList.add("array_list_3");
        arrayList.add("crray_list_2");
    }

    private static Collection<String> linkedList = new LinkedList<>();
    static {
        linkedList.add("linked_list_1");
        linkedList.add("linked_list_2");
        linkedList.add("linked_list_3");
    }

    private static Collection<String> hashSet = new HashSet<>();
    static {
        hashSet.add("hash_set_1");
        hashSet.add("hash_set_2");
        hashSet.add("hash_set_3");
    }

    private static Collection<String> treeSet = new TreeSet<>();
    static {
        treeSet.add("tree_set_1");
        treeSet.add("tree_set_2");
        treeSet.add("tree_set_3");
    }

    static Collection<String> getCollection(int i) {
        switch (i) {
            case 1:
                return arrayList;
            case 2:
                return linkedList;
            case 3:
                return hashSet;
            case 4:
                return treeSet;
            default:
                throw new IllegalArgumentException("i must be in [1, 4]");
        }
    }

    public static List<String> getList() {
        return arrayList;
    }

}
