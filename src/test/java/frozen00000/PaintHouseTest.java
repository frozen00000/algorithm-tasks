package frozen00000;

import org.junit.Test;

public class PaintHouseTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(PaintHouse::main);
    }

}
