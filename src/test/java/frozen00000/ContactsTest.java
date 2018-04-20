package frozen00000;

import org.junit.Test;

public class ContactsTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(Contacts::main);
    }

    @Test
    public void test2() {
        assertAgainstResource("ContactsTest2.input", Contacts::main, "ContactsTest2.output");
    }

    @Test
    public void test3() {
        assertAgainstResource("ContactsTest3.input", Contacts::main, "ContactsTest3.output");
    }

}
