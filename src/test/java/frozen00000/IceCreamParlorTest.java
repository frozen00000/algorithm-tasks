package frozen00000;

import org.junit.Test;

public class IceCreamParlorTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(IceCreamParlor::main);
    }

}