package imkn.templatemethod;


import java.util.Arrays;
import java.util.List;

public class TestRunner {

    public static void main(String[] args) {

        IMKNUnitTestBase test1 = new SimpleSummatorTest();
        IMKNUnitTestBase test2 = new IteratorJDK_5_8_Test();
        IMKNUnitTestBase test3 = new TimelogSummatorTest();

        List<IMKNUnitTestBase> testSuite = Arrays.asList(test1, test2, test3);

        testSuite.forEach(IMKNUnitTestBase::runTest);
    }

}
