package frozen00000;

import org.junit.Test;

public class TaleOfTwoStacksTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(TaleOfTwoStacks::main);
    }

}
