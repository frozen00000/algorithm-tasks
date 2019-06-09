package frozen00000;

import org.junit.Test;

public class AlternatingCharactersTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(AlternatingCharacters::main);
    }

}
