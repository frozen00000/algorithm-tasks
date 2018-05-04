package frozen00000;

import org.junit.Test;

public class BubbleSortTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(BubbleSort::main);
    }

}