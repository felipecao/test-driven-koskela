import java.util.List;
import java.util.stream.Collectors;

public class TemplateParse {

    private StringBreaker breaker;
    private SegmentFactory segmentFactory;

    public TemplateParse() {
        this.breaker = new StringBreaker();
        this.segmentFactory = new SegmentFactory();
    }

    public List<Segment> parseSegments(String template) {
        return breaker.breakStringIntoChunks(template)
                .stream()
                .map(s -> segmentFactory.build(s))
                .collect(Collectors.toList());
    }
}
