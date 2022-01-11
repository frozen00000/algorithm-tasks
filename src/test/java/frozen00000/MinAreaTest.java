package frozen00000;

import org.junit.Test;

public class MinAreaTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(MinArea::main);
    }

}
