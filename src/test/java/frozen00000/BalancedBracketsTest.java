package frozen00000;

import org.junit.Test;

public class BalancedBracketsTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(BalancedBrackets::main);
    }

}
