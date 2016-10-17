package imkn.decorator;


public class Decorator_1 {

    static void runSummator(Summator summator) {

        System.out.println(summator.sum(100));
        System.out.println(summator.sum(10000));
        System.out.println(summator.sum(1000000));
        System.out.println(summator.sum(100000000));

    }

    public static void main(String[] args) {
        Summator summator = new SimpleSummator();
        runSummator(summator);
    }

}
