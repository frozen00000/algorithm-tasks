package frozen00000;

import org.junit.Test;

public class AbbreviationTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(Abbreviation::main);
    }

}
