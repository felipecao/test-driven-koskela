import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestVariableSegment
{
    private Map<String, String> variables;

    @Before
    public void setUp() throws Exception
    {
        variables = new HashMap<>();
    }

    @Test
    public void variableEvaluatesToItsValue()
    {
        String name = "myvar";
        String value = "myvalue";

        variables.put(name, value);

        assertEquals(value, new Variable(name).evaluate(variables));
    }

    @Test
    public void missingVariableRaisesException()
    {
        String name = "myvar";

        try {
            new Variable(name).evaluate(variables);
            fail("Missing variable value should raise an exception");
        } catch (MissingValueException expected) {
            assertEquals("No value for ${" + name + "}", expected.getMessage());
        }
    }

    @Test
    public void appendToAppendsVariableValue()
    {
        StringBuilder result = new StringBuilder();
        String name = "myvar";
        String value = "myvalue";
        Segment variableSegment = new Variable(name);

        variables.put(name, value);
        variableSegment.appendTo(result, variables);

        assertEquals(value, result.toString());
    }
}
