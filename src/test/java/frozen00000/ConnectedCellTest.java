package frozen00000;

import org.junit.Test;

public class ConnectedCellTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(ConnectedCell::main);
    }

}