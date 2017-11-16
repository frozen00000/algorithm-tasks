package frozen00000;

import frozen0000.PigBank;
import frozen00000.TestWithResources;
import org.junit.Test;

public class PigBankTest extends TestWithResources {

    @Test
    public void main() {
        resourceToInputStream();
        PigBank.main(new String[] {});
        assertResultAgainstResource();
    }

}