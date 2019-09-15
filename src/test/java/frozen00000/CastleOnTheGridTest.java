package frozen00000;

import org.junit.Test;

public class CastleOnTheGridTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(CastleOnTheGrid::main);
    }

}
