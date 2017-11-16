package frozen00000;

import org.junit.Test;

public class PigBankTest extends TestWithResources {

    @Test
    public void main() {
        resourceToInputStream();
        PigBank.main(new String[] {});
        assertResultAgainstResource();
    }

}