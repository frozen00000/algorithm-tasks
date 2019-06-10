package frozen00000;

import org.junit.Test;

public class FraudulentActivityNotificationsTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(FraudulentActivityNotifications::main);
    }

    @Test
    public void test2() {
        assertAgainstResource("FraudulentActivityNotificationsTest2.input", FraudulentActivityNotifications::main, "FraudulentActivityNotificationsTest2.output");
    }

}