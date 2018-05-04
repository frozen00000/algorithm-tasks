package frozen00000;

import org.junit.Test;

public class MakingAnagramsTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(MakingAnagrams::main);
    }

}
