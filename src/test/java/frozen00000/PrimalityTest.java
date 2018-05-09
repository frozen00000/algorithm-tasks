package frozen00000;

import org.junit.Test;

public class PrimalityTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(Primality::main);
    }

}