package frozen00000;

import org.junit.Test;

public class WordLadderTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(WordLadder::main);
    }

}
