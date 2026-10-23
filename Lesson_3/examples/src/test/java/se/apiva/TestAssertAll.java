package se.apiva;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAssertAll {

    @Test
    public void testBookGetters() {
        Book book = new Book(
                "Dungeon Crawler Carl",
                "Matt Dinniman",
                2008
            );

        assertAll(
                "Testing book properties",
                () -> assertEquals("Dungeon Crawler Carl", book.getTitle()),
                () -> assertEquals("Matt Dinniman", book.getAuthor()),
                () -> assertEquals(2008, book.getPublicationYear())
        );
    }

}
