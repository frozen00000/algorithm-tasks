package frozen00000;

import org.junit.Test;

public class CrosswordPuzzleTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(CrosswordPuzzle::main);
    }

}
