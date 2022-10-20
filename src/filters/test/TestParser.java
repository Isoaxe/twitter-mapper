package filters.test;

import filters.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test the parser.
 */
public class TestParser {
    @Test
    public void testBasic() throws SyntaxError {
        Filter f = new Parser("trump").parse();
        assertTrue(f instanceof BasicFilter);
        assertTrue(((BasicFilter)f).getWord().equals("trump"));
    }

    @Test
    // Test combinations of logic operators, e.g. AND, OR and NOT.
    public void testLogicOps() throws SyntaxError {
        Filter f1 = new Parser("trump and not purple").parse(); // AND statement
        assertTrue(f1.toString().equals("(trump and not purple)")); // outer parens only

        Filter f2 = new Parser("trump and not purple or green").parse(); // AND/OR statement
        assertTrue(f2.toString().equals("((trump and not purple) or green)")); // parens wrap AND terms first

        Filter f3 = new Parser("trump or not purple and green").parse(); // OR/AND statement
        assertTrue(f3.toString().equals("(trump or (not purple and green))")); // parens wrap AND terms first

        Filter f4 = new Parser("trump and not (purple or green)").parse(); // AND/OR with OR terms pre-wrapped
        assertTrue(f4.toString().equals("(trump and not (purple or green))")); // outer additional parens only

        Filter f5 = new Parser("trump and not purple and green").parse(); // AND/AND statement
        assertTrue(f5.toString().equals("((trump and not purple) and green)")); // parens wrap first AND terms first

        Filter f6 = new Parser("trump or not not not purple").parse(); // NOT x 3
        assertTrue(f6.toString().equals("(trump or not not not purple)")); // outer parens only
    }

    @Test
    public void testHairy() throws SyntaxError {
        Filter x = new Parser("trump and (evil or blue) and red or green and not not purple").parse();
        assertTrue(x.toString().equals("(((trump and (evil or blue)) and red) or (green and not not purple))"));
    }

    @Test
    public void testError() {
        try {
            new Parser("trump not purple").parse(); // Correct syntax is "and not".
            fail("Prior assertion should have thrown a SyntaxError...");
        } catch (SyntaxError se) {
            // SyntaxError caught here as expected. Do nothing.
        }
        try {
            new Parser("trump and or purple").parse(); // Illegal combo. Use AND || OR, not both together.
            fail("Prior assertion should have thrown a SyntaxError...");
        } catch (SyntaxError se) {
            // SyntaxError caught here as expected. Do nothing.
        }
    }
}
