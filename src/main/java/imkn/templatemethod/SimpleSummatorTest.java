package imkn.templatemethod;


import imkn.decorator.SimpleSummator;
import imkn.decorator.Summator;

import java.math.BigInteger;

public class SimpleSummatorTest extends IMKNUnitTestBase {

    protected Summator summator;

    @Override
    protected void setup() {
        summator = new SimpleSummator();
    }

    @Override
    protected boolean run() {
        return BigInteger.valueOf(4950).equals(summator.sum(100)) &&
                new BigInteger("49995000").equals(summator.sum(10000)) &&
                new BigInteger("499999500000").equals(summator.sum(1000000)) &&
                new BigInteger("4999999950000000").equals(summator.sum(100000000));
    }

}
