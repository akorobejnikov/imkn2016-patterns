package imkn.templatemethod;

import imkn.iterator.IteratorCollectionHolder;

import java.util.List;


public class IteratorJDK_5_8_Test extends IMKNUnitTestBase {


    @Override
    protected boolean run() {
        List<String> list = IteratorCollectionHolder.getList();

        int sumJDK8 = list.stream().mapToInt(String::length).sum();

        int sumJDK5 = 0;
        for (String s: list) {
            sumJDK5 += s.length();
        }

        return sumJDK5 == sumJDK8 - 1; // fail
    }
}
