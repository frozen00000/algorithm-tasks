package frozen00000;

import org.junit.Test;

public class CutTheSticksTest extends TestWithResources {

    @Test
    public void case1() {
        assertAgainstResource(CutTheSticks::main);
    }

    @Test
    public void case2() {
        assertAgainstResource("CutTheSticksTest2.input", CutTheSticks::main, "CutTheSticksTest2.output");
    }

}
