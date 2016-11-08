import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestPlainTextSegment
{
    @Test
    public void plainTextEvaluatesAsIs()
    {
        Map<String, String> variables = new HashMap<>();
        String text = "abc def";

        assertEquals(text, new PlainText(text).evaluate(variables));
    }

    @Test
    public void appendToAppendsTextItself()
    {
        StringBuilder result = new StringBuilder();
        Map<String, String> variables = new HashMap<>();
        String text = "abc def";
        Segment plainTextSegment = new PlainText(text);

        plainTextSegment.appendTo(result, variables);

        assertEquals(text, result.toString());
    }
}
