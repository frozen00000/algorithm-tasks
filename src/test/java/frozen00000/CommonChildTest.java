package frozen00000;

import org.junit.Test;

public class CommonChildTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(CommonChild::main);
    }

}
