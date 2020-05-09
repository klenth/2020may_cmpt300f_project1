package java_code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Words {

    private static final Path WORDS_FILE = Path.of("words");

    public static void main(String[] args) throws IOException {
        Files.lines(WORDS_FILE)
                .filter(word -> word.length() > 16)
                .sorted((w1, w2) -> w1.length() - w2.length())
                .map(word -> word.length() + ": " + word)
                .forEach(word -> System.out.println(word));
    }
}
