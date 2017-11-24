package frozen00000;

import org.junit.Test;

public class DuffTest extends TestWithResources {

    @Test
    public void main() {
        assertAgainstResource(Duff::main);
    }
}