package imkn.decorator;


public class Decorator_3 {

    public static void main(String[] args) {
        Summator summator = new TimelogSummatorDecorator(new LoggingSummatorDecorator(new SimpleSummator()));
        Decorator_1.runSummator(summator);
    }

}
