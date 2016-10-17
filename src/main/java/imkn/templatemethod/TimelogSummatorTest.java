package imkn.templatemethod;

import imkn.decorator.SimpleSummator;
import imkn.decorator.TimelogSummatorDecorator;


public class TimelogSummatorTest extends SimpleSummatorTest {

    @Override
    protected void setup() {
        summator = new TimelogSummatorDecorator(new SimpleSummator());
    }

}
