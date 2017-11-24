package frozen00000;

import org.junit.Test;

public class PigBankTest extends TestWithResources {

    @Test
    public void main() {
        assertAgainstResource(PigBank::main);
    }

}