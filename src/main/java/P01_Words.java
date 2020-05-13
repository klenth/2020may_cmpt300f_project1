import java.util.List;
import java.util.stream.Collectors;

public class P01_Words {

    /*
     * Returns a list of just the words whose length are less than 6, in the same order that they were originally.
     * You must do this using a single call to Stream.filter() with a lambda!
     */
    public List<String> shortWords(List<String> words) {
        return words.stream()
                // Use an appropriate call to .filter() here

                .collect(Collectors.toList());
    }

    /*
     * Returns a list where every word has been "pig-Latinized," that is, the first character is moved to the end and
     * then followed by "ay". (For example, "computer" becomes "omputercay" and "program" becomes "rogrampay".) You must
     * do this using a single call to Stream.map() with a lambda!
     * (You can assume that every word has at least one character — you don't need to check for empty strings.)
     */
    public List<String> pigLatin(List<String> words) {
        return words.stream()
                // Use an appropriate call to .map() here

                .collect(Collectors.toList());
    }

    /*
     * Returns a list that has been sorted by the last character. (For example, [zebra, rhubarb, ceramic] is in sorted
     * order because the last characters are a, b, and c). You must do this using a single call to Stream.sorted() with
     * a lambda!
     * (You can assume that every word has at least one character — you don't need to check for empty strings.)
     */
    public List<String> sortByLastCharacter(List<String> words) {
        return words.stream()
                // Use an appropriate call to .sorted() here

                .collect(Collectors.toList());
    }

    /*
     * Returns a list that has had the following done to it, in order:
     * 1) Kept just the words of length less than 6
     * 2) Sorted by last character
     * 3) Been "pig-Latinized" (as in the pigLatin() method).
     * You must do this using one call each to Stream.filter(), Stream.map(), Stream.sorted() (not necessarily in that
     * order) with lambdas!
     * (You can assume that every word has at least one character — you don't need to check for empty strings.)
     */
    public List<String> transformWords(List<String> words) {
        return words.stream()
                // Use appropriate calls to .filter(), .map(), and .sorted() here

                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Put any code you want here for testing purposes

    }
}
