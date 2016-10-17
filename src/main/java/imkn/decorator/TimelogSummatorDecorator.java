package imkn.decorator;


import java.math.BigInteger;

public class TimelogSummatorDecorator implements Summator {

    private Summator summator;

    public TimelogSummatorDecorator(Summator summator) {
        this.summator = summator;
    }

    @Override
    public BigInteger sum(int size) {
        long start = System.currentTimeMillis();
        BigInteger sum = summator.sum(size);
        System.out.println("run time: " + (System.currentTimeMillis() - start) + " msec"); // в реальности так не надо никогда бенчмаркать!!!
        return sum;
    }

}
