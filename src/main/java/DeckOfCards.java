import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DeckOfCards {
    private List<Cards> cards;

    public DeckOfCards() {
        this.cards = new LinkedList<>();
        for(int i =0; i<4;i+=1){
            this.cards.add(Cards.RUSSIA);
            this.cards.add(Cards.POLICE);
            this.cards.add(Cards.EUROPEAN_UNION);
            this.cards.add(Cards.MEDIA);
            this.cards.add(Cards.PROTEST);
        }
    }
    public Cards GetCard(){
        // TODO add exception when number of cards is 0;
        int n=cards.size();
        Random rand=new Random();
        int card_index= rand.nextInt(n);
        return cards.remove(card_index);
    }
    public void AddCard(Cards card){
        cards.add(card);
    }

    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        System.out.println(deck.cards);
        System.out.println(deck.cards.size());
        System.out.println(deck.GetCard());
        System.out.println(deck.GetCard());
        System.out.println(deck.GetCard());
        System.out.println(deck.GetCard());
        System.out.println(deck.GetCard());
        System.out.println(deck.GetCard());
        System.out.println(deck.GetCard());
        System.out.println(deck.cards.size());
        deck.AddCard(Cards.MEDIA);
        System.out.println(deck.cards.size());


    }
}
