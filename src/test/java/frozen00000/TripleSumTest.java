package frozen00000;

import org.junit.Test;

public class TripleSumTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(TripleSum::main);
    }

}
