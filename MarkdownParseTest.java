import static org.junit.Assert.*;
import org.junit.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class MarkdownParseTest {
    private static final int NUM_OF_CASES = 11;
    @Before
    private
    private void Setup() {
        ArrayList<String> StringArrayList = new ArrayList()
        for(int i = 0; i < NUM_OF_CASES; i++) {

        }
    }

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void test_testFile() {
        String content = Files.readString(test-file.md);
        ArrayList<String> links = getLinks(content);

        assertEquals("https://something.com", MarkdownParse.getLinks("test-file.md").get(0));
        assertEquals("some-page.html", MarkdownParse.getLinks("test-file.md").get(1));

    }

    @Testpublic

}