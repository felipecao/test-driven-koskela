import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestTemplatePerformance {

    private Template template;

    @Before
    public void setup() {
        template = new TestTemplateBuilder().buildTemplate();
    }

    @Test
    public void templateWith100WordsAnd20Variables() {
        Long expected = 200L;
        Long time = System.currentTimeMillis();

        template.evaluate();

        time = System.currentTimeMillis() - time;

        assertTrue("Rendering the template took " + time + "ms while the target was " + expected + "ms", time <= expected);
    }

}
