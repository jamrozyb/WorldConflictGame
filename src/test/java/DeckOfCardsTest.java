import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeckOfCardsTest {
    @Test
    void shouldInitWith20Cards(){
        DeckOfCards deck = new DeckOfCards();
        assertEquals(deck.GetDeckSize(),20);
    }
    @Test
    void writeNumberCartLeftInDeck(){
        DeckOfCards deck = new DeckOfCards();
        deck.GetCard();
        deck.GetCard();
        deck.GetCard();
        assertEquals(deck.GetDeckSize(),17);
    }
}
