import java.util.List;

public class Player {
    private String name;
    private Cards card1;
    private Cards card2;
    private Boolean isCart1Activ = true;
    private Boolean isCart2Activ = true;
    private int money;
    private List<Player> players;
    private DeckOfCards deck;


    public Player(String name, Cards card1, Cards card2,DeckOfCards deck) {
        this.name = name;
        this.card1 = card1; // it not necessary to take cards as param in constructor. Carts may by los from deck, but it make testing difficult.
        this.card2 = card2;
        this.deck=deck;
        money=0;
    }
//    Usa action don't requires else players reaction
    public void Usa(){
        money+=1_000_000;
    }
    public void LocalBusinessmen(){}
    public void Affair(){}
    public void Russia(){}
    public void Protest(){}
    public void Media(){}
    public void Police(){}
    public void EuropeanUnion(){}



}
