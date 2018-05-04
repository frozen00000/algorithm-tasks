package frozen00000;

import org.junit.Test;

public class CountingInversionsTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(CountingInversions::main);
    }

}
