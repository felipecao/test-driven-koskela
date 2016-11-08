public class SegmentFactory
{
    public Segment build(String input)
    {
        if (TemplateParse.isVariable(input)) {
            return new Variable(extractVariableName(input));
        }
        return new PlainText(input);
    }

    private String extractVariableName(String input)
    {
        return input.replace("${", "").replace("}", "");
    }
}
