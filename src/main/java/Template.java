import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Template {

    private Map<String, String> variables;
    private String templateText;

    public Template(String templateText) {
        variables = new HashMap<>();
        this.templateText = templateText;
    }

    public void set(String variable, String value) {
        this.variables.put(variable, value);
    }

    public String evaluate() {
        TemplateParse parser = new TemplateParse();
        List<Segment> segments = parser.parseSegments(templateText);

        return concatenate(segments);
    }

    private String concatenate(List<Segment> segments)
    {
        StringBuilder result = new StringBuilder();

        for (Segment segment: segments) {
            segment.appendTo(result, variables);
        }

        return result.toString();
    }
}
