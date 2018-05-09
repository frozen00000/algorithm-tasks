package frozen00000;

import org.junit.Test;

public class ShortestReachTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(ShortestReach::main);
    }

}