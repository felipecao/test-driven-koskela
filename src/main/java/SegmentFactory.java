public class SegmentFactory
{
    private static final String VARIABLE_START = "${";
    private static final String VARIABLE_END = "}";
    private static final String EMPTY = "";

    public Segment build(String input)
    {
        if (isVariable(input)) {
            return new Variable(extractVariableName(input));
        }
        return new PlainText(input);
    }

    private static boolean isVariable(String segment) {
        return segment.startsWith(VARIABLE_START) && segment.endsWith(VARIABLE_END);
    }

    private String extractVariableName(String input) {
        return input.replace(VARIABLE_START, EMPTY).replace(VARIABLE_END, EMPTY);
    }
}
