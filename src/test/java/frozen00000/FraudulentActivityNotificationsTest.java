package frozen00000;

import org.junit.Test;

public class FraudulentActivityNotificationsTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(FraudulentActivityNotifications::main);
    }

    @Test
    public void test2() {
        assertAgainstResource("SherlockAndAnagramsTest2.input", FraudulentActivityNotifications::main, "SherlockAndAnagramsTest2.output");
    }

}