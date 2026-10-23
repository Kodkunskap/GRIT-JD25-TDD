import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    WordCounter wordCounter = null;

    @BeforeEach
    void beforeAll() {
        this.wordCounter = new WordCounter();
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    @NullSource     // tack Iffe!
    public void nullOrBlankReturnsZero(String input) {
        int result = this.wordCounter.countWords(input);

        assertEquals(0, result);
    }

    @Test
    @DisplayName("0 on empty string")
    public void emptyStringReturnsZero() {
        int result = wordCounter.countWords("");

        assertEquals(0, result);
    }

    @Test
    @DisplayName("0 on NULL-string")
    public void nullStringReturnsZero() {
        int result = wordCounter.countWords(null);

        assertEquals(0, result);
    }

    @Test
    @DisplayName("1 word returns 1")
    public void oneWordReturnsOne() {
        int result = wordCounter.countWords("oneWord");

        assertEquals(1, result);
    }

    @Test
    @DisplayName("3 words returns 3")
    public void multipleWordsReturnsTheNumberOfWords() {
        int result = wordCounter.countWords("wordOne wordTwo wordThree");

        assertEquals(3, result);
    }

    @Test
    @DisplayName("multiple of the same word returns 1")
    public void multipleOfTheSameWordReturnsOne() {
        int result = wordCounter.countWords("uniqueWord uniqueWord uniqueWord");

        assertEquals(1, result);
    }

    @Test
    @DisplayName("2 of the same word and one uniqueWord should return 2")
    public void twoOfTheSameWordAndOneUniqueWordReturnsTwo() {
        int result = wordCounter.countWords("oneWord oneWord uniqueWord");

        assertEquals(2, result);
    }

    @Test
    @DisplayName("upper- and lower case letters should not impact unqiue words")
    public void upperCaseLettersShouldNotImpactUnqiueWords() {
        int result = wordCounter.countWords("uniqueWord UniqueWord UNiqueword uniqueword");

        assertEquals(1, result);
    }

}
