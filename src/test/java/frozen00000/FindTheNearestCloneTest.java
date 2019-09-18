package frozen00000;

import org.junit.Test;

public class FindTheNearestCloneTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(FindTheNearestClone::main);
    }

    @Test
    public void test2() {
        assertAgainstResource("FindTheNearestCloneTest2.input", FindTheNearestClone::main, "FindTheNearestCloneTest2.output");
    }

    @Test
    public void test3() {
        assertAgainstResource("FindTheNearestCloneTest3.input", FindTheNearestClone::main, "FindTheNearestCloneTest3.output");
    }

}
