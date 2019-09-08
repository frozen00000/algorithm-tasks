package frozen00000;

import org.junit.Test;

public class MaxArraySumTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(MaxArraySum::main);
    }

}
