package frozen00000;

import org.junit.Test;

public class SherlockAndTheValidStringTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(SherlockAndTheValidString::main);
    }

    @Test
    public void test2() {
        assertAgainstResource("SherlockAndTheValidStringTest2.input", SherlockAndTheValidString::main,
                "SherlockAndTheValidStringTest2.output");
    }

    @Test
    public void test3() {
        assertAgainstResource("SherlockAndTheValidStringTest3.input", SherlockAndTheValidString::main,
                "SherlockAndTheValidStringTest3.output");
    }

}
