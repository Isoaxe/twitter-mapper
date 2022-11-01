package filters.test;

import filters.Scanner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestScanner {
    @Test
    public void testBasic() {
        Scanner x = new Scanner("trump");
        assertTrue(x.nextToken().equals("trump"));
        assertTrue(x.advanceAndNextToken() == null);
    }

    @Test
    public void testAnd() {
        Scanner x = new Scanner("trump and evil");
        assertTrue(x.nextToken().equals("trump"));
        assertTrue(x.advanceAndNextToken().equals("and"));
        assertTrue(x.nextToken().equals("and"));
        assertTrue(x.advanceAndNextToken().equals("evil"));
        assertTrue(x.nextToken().equals("evil"));
        assertTrue(x.advanceAndNextToken() == null);
    }

    @Test
    public void testAll() {
        String expected[] = { "trump", "and", "(", "evil",
                "or", "not", "(", "good", ")", ")" };
        runTest("trump and (evil or not (good))", expected);
    }

    @Test
    public void testOr() {
        String expected[] = { "trump", "or", "evil" };
        runTest("trump or evil", expected);
    }

    private void runTest(String input, String[] expected) {
        Scanner x = new Scanner(input);
        boolean first = true;
        for (String token : expected) {
            if (first) {
                first = false;
            } else {
                assertTrue(x.advanceAndNextToken().equals(token));
            }
            assertTrue(x.nextToken().equals(token));
        }
        assertTrue(x.advanceAndNextToken() == null);
    }
}
