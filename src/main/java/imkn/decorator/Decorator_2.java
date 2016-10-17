package imkn.decorator;


public class Decorator_2 {

    public static void main(String[] args) {
        Summator summator = new LoggingSummatorDecorator(new SimpleSummator());
        Decorator_1.runSummator(summator);
    }

}
