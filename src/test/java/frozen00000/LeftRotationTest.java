package frozen00000;

import org.junit.Test;

public class LeftRotationTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(LeftRotation::main);
    }

}
