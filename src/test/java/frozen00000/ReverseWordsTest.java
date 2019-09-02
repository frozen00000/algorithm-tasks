package frozen00000;

import org.junit.Test;

public class ReverseWordsTest extends TestWithResources {

	@Test
	public void test() {
		assertAgainstResource(ReverseWords::main);
	}

}