package frozen00000;

import org.junit.Test;

public class RoadsAndLibrariesTest extends TestWithResources {

    @Test
    public void main() {
        assertAgainstResource(RoadsAndLibraries::main);
    }

}
