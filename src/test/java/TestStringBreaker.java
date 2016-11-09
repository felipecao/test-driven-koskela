import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestStringBreaker
{
    private StringBreaker breaker;

    @Before
    public void setup() {
        breaker = new StringBreaker();
    }

    @Test
    public void emptyTemplateRendersAsEmptyString()
    {
        List<String> segments = breakInput("");

        assertSegments(segments, "");
    }

    @Test
    public void templateWithOnlyPlainText()
    {
        List<String> segments = breakInput("plain text only");

        assertSegments(segments, "plain text only");
    }

    @Test
    public void parsingMultipleVariables()
    {
        List<String> segments = breakInput("${a}:${b}:${c}");

        assertSegments(segments, "${a}", ":", "${b}", ":", "${c}");
    }

    @Test
    public void parsingTemplateIntoSegmentObjects()
    {
        List<String> segments = breakInput("a ${b} c ${d}");

        assertSegments(segments, "a ", "${b}", " c ", "${d}");
    }

    private List<String> breakInput(String template)
    {
        return breaker.breakStringIntoChunks(template);
    }

    private void assertSegments(List<String> actual, String... expected)
    {
        assertEquals("Number of objects doesn't match", expected.length, actual.size());
        assertEquals(Arrays.asList(expected), actual);
    }
}
