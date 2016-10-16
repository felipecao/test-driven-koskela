import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTemplate {

    @Test
    public void oneVariable() {
        Template template = new Template("Hello, ${name}");

        template.set("name", "Reader");

        assertEquals("Hello, Reader", template.evaluate());
    }

}
