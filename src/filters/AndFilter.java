package filters;

import twitter4j.Status;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A filter that represents the logical AND of its two children filters
 */
public class AndFilter implements Filter {
    private final Filter child1;
    private final Filter child2;

    public AndFilter(Filter child1, Filter child2) {
        this.child1 = child1;
        this.child2 = child2;
    }

    /**
     * An AND filter matches when both of its children match the tweet
     * @param s     the tweet to check
     * @return      whether or not it matches
     */
    @Override
    public boolean matches(Status s) {
        return child1.matches(s) && child2.matches(s);
    }

    @Override
    public List<String> terms() {
        return Stream.concat(child1.terms().stream(), child2.terms().stream()).collect(Collectors.toList());
    }

    public String toString() {
        return "(" + child1.toString() + " and " + child2.toString() + ")";
    }
}
