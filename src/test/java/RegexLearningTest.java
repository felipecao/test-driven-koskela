import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(DataProviderRunner.class)
public class RegexLearningTest
{
    @Test
    @DataProvider({
        "(needle)", "needle"
    })
    public void testFindStartAndEnd(String expression)
    {
        String haystack = "The needle shop sells needles";
        String regex = expression;
        Matcher matcher = Pattern.compile(regex).matcher(haystack);

        assertTrue(matcher.find());
        assertEquals("Wrong start index of 1st match", 4, matcher.start());
        assertEquals("Wrong end index of 1st match", 10, matcher.end());

        assertTrue(matcher.find());
        assertEquals("Wrong start index of 2nd match", 22, matcher.start());
        assertEquals("Wrong end index of 2nd match", 28, matcher.end());

        assertFalse("Should not have any more matches", matcher.find());
    }
}
