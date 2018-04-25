package frozen00000;

import org.junit.Test;

public class RansomNoteTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(RansomNote::main);
    }

    @Test
    public void test2() {
        assertAgainstResource("RansomNoteTest2.input", RansomNote::main, "RansomNoteTest2.output");
    }
}
