import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class TestTemplateBuilder {

    private static final Integer TOTAL_WORDS = 100;
    private static final Integer TOTAL_VARIABLES = 20;
    private static final Integer MIN_CHARS_PER_WORD = 13;
    private static final Integer MAX_CHARS_PER_WORD = 17;
    private static final String SPACE = " ";

    public Template buildTemplate() {
        Map<String, String> variablesAndValues = buildVariablesWithValues();
        String templateText = buildTemplateText(variablesAndValues);
        Template template = new Template(templateText);

        setAllVariables(template, variablesAndValues);

        return template;
    }

    private Map<String, String> buildVariablesWithValues() {

        Map<String, String> variablesAndValues = new HashMap<>();

        for (int i = 0; i < TOTAL_VARIABLES; i++) {
            variablesAndValues.put(randomWord(), randomWord());
        }

        return variablesAndValues;
    }

    private String buildTemplateText(Map<String, String> variablesAndValues) {

        StringBuilder builder = new StringBuilder();

        appendAllVariables(builder, variablesAndValues);
        appendRandomWords(builder);

        return builder.toString();
    }

    private void appendRandomWords(StringBuilder builder) {
        for (int totalAddedWords = TOTAL_VARIABLES; totalAddedWords < TOTAL_WORDS; totalAddedWords++) {
            builder.append(randomWord()).append(SPACE);
        }
    }

    private void appendAllVariables(StringBuilder builder, Map<String, String> variablesAndValues) {
        for (String key: variablesAndValues.keySet()) {
            builder.append(keyToVariable(key)).append(SPACE);
        }
    }

    private void setAllVariables(Template template, Map<String, String> variablesAndValues) {
        for (Map.Entry<String, String> entry: variablesAndValues.entrySet()) {
            template.set(entry.getKey(), entry.getValue());
        }
    }

    private String randomWord() {
        return randomAlphabetic(MIN_CHARS_PER_WORD, MAX_CHARS_PER_WORD);
    }

    private String keyToVariable(String key) {
        return String.format("${%s}", key);
    }

}
