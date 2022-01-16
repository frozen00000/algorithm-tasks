package frozen00000;

import org.junit.Test;

public class ZigzagConversionTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(ZigzagConversion::main);
    }

}
