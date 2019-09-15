package frozen00000;

import org.junit.Test;

public class MinimumTimeRequiredTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(MinimumTimeRequired::main);
    }

}
