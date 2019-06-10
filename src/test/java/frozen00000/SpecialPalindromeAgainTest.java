package frozen00000;

import org.junit.Test;

public class SpecialPalindromeAgainTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(SpecialPalindromeAgain::main);
    }

    @Test
    public void test2() {
        assertAgainstResource("SpecialPalindromeAgainTest2.input", SpecialPalindromeAgain::main,
                "SpecialPalindromeAgainTest2.output");
    }

    @Test
    public void test3() {
        assertAgainstResource("SpecialPalindromeAgainTest3.input", SpecialPalindromeAgain::main,
                "SpecialPalindromeAgainTest3.output");
    }

    @Test
    public void test4() {
        assertAgainstResource("SpecialPalindromeAgainTest4.input", SpecialPalindromeAgain::main,
                "SpecialPalindromeAgainTest4.output");
    }

}
