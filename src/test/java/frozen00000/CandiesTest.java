package frozen00000;

import org.junit.Test;

public class CandiesTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(Candies::main);
    }

}
