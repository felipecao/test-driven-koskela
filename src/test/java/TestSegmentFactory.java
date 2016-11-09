import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class TestSegmentFactory {

    private SegmentFactory segmentFactory;

    @Before
    public void setup() {
        segmentFactory = new SegmentFactory();
    }

    @Test
    public void textWithVariableMarkupReturnsVariableInstance() {
        String input = "${a}";
        Segment segment = segmentFactory.build(input);

        assertEquals(new Variable(extractVariableName(input)), segment);
    }

    @Test
    @DataProvider({
            "a", "$a", "${a", "$a}", "a}"
    })
    public void textWithoutFullVariableMarkupReturnsPlainTextInstance(String input) {
        Segment segment = segmentFactory.build(input);

        assertEquals(new PlainText(input), segment);
    }

    private String extractVariableName(String input) {
        return input.replace("${", "").replace("}", "");
    }
}
