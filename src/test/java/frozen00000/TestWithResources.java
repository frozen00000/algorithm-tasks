package frozen00000;

import org.junit.After;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class TestWithResources {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    private String getDefaultInputResourceName() {
        return getClass().getSimpleName() + ".input";
    }

    private String getDefaultOutputResourceName() {
        return getClass().getSimpleName() + ".output";
    }

    protected void resourceToInputStream(String name) {
        System.setIn(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(name)));
    }

    protected void resourceToInputStream() {
        resourceToInputStream(getDefaultInputResourceName());
    }

    private void assertResult(String expected) {
        assertEquals(expected, outContent.toString().trim());
    }

    protected void assertResultAgainstResource(String expectedResource) {
        String expectedResult = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(expectedResource)))
        ).lines().collect(Collectors.joining("\n"));
        assertResult(expectedResult);
    }

    protected void assertResultAgainstResource() {
        assertResultAgainstResource(getDefaultOutputResourceName());
    }

    protected void assertAgainstResource(Consumer<String[]> runnable) {
        assertAgainstResource(getDefaultInputResourceName(), runnable);
    }

    protected void assertAgainstResource(String resourceName, Consumer<String[]> runnable) {
        assertAgainstResource(resourceName, runnable, getDefaultOutputResourceName());
    }

    protected void assertAgainstResource(String resourceName, Consumer<String[]> runnable, String outputResourceName) {
        resourceToInputStream(resourceName);
        runnable.accept(new String[] {});
        assertResultAgainstResource(outputResourceName);
    }

}
