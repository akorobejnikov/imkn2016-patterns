package imkn.decorator;


import java.math.BigInteger;

public class SimpleSummator implements Summator {

    @Override
    public BigInteger sum(int size) {

        BigInteger sum1 = BigInteger.ZERO;
        for (int i = 0; i < size; i++) {
            sum1 = sum1.add(BigInteger.valueOf(i));
        }

        return sum1;
    }

}
