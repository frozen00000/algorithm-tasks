package frozen00000;

import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharactersTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(LongestSubstringWithoutRepeatingCharacters::main);
    }

}
