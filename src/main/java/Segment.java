import java.util.Map;

public interface Segment
{
    String evaluate(Map<String, String> variables);

    void appendTo(StringBuilder result, Map<String, String> variables);
}
