import java.util.HashSet;
import java.util.Set;

public class WordCounter {

    public int countWords(String s) {
        Set<String> words = new HashSet<>();

        if(s == null || s.isEmpty()) {
            return 0;
        }

        for (String word : s.split(" ")) {
            words.add(word.toLowerCase());
        }
        return words.size();
    }

}
