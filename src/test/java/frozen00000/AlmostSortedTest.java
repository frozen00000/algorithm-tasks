package frozen00000;

import org.junit.Test;

public class AlmostSortedTest extends TestWithResources {

    @Test
    public void main() {
        assertAgainstResource(AlmostSorted::main);
    }

    @Test
    public void case2() {
        assertAgainstResource("AlmostSortedTest2.input", AlmostSorted::main, "AlmostSortedTest2.output");
    }

    @Test
    public void case3() {
        assertAgainstResource("AlmostSortedTest3.input", AlmostSorted::main, "AlmostSortedTest3.output");
    }

    @Test
    public void case4() {
        assertAgainstResource("AlmostSortedTest4.input", AlmostSorted::main, "AlmostSortedTest4.output");
    }

    @Test
    public void case5() {
        assertAgainstResource("AlmostSortedTest5.input", AlmostSorted::main, "AlmostSortedTest5.output");
    }

}
