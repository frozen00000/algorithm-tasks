package frozen00000;

import org.junit.Test;

public class DavisStaircaseTest extends TestWithResources {

    @Test
    public void main() {
        assertAgainstResource(DavisStaircase::main);
    }

}
