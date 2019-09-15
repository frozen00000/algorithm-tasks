package frozen00000;

import org.junit.Test;

public class FriendCircleQueriesTest extends TestWithResources {

    @Test
    public void test() {
        assertAgainstResource(FriendCircleQueries::main);
    }

}
