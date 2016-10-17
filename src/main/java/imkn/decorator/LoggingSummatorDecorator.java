package imkn.decorator;


import java.math.BigInteger;

public class LoggingSummatorDecorator implements Summator {

    private Summator summator;

    public LoggingSummatorDecorator(Summator summator) {
        this.summator = summator;
    }

    @Override
    public BigInteger sum(int size) {
        System.out.println("calculate sum of " + size + " numbers");
        return summator.sum(size);
    }
}
