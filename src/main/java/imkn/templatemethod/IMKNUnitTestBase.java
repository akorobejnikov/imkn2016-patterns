package imkn.templatemethod;


public abstract class IMKNUnitTestBase {

    abstract protected boolean run();

    protected void setup() {}

    protected void tearDown() {}

    protected String getTestName() {
        return getClass().getSimpleName();
    }

    // template method
    public void runTest() {

        System.out.println("setup test" + getTestName());
        setup();

        System.out.println("start test" + getTestName());
        long start = System.currentTimeMillis();

        boolean result = run();
        String resultString;
        if (result) {
            resultString = "success";
        } else {
            resultString = "fail";
        }

        System.out.println("end test" + getTestName() + "\n" +
            "time: " + (System.currentTimeMillis() - start) + " msec\n" +
            "result: " + resultString + "\n");
    }

}
