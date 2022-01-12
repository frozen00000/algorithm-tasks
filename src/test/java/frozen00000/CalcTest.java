package frozen00000;

import org.junit.Test;

public class CalcTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(Calc::main);
    }

}
