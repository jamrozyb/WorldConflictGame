import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player {
    private static int id=0;
    private static GameCommunication gameCommunication;
    private int playerId;
    private String name;
    private Cards card1;
    private Cards card2;
    private Boolean isCart1Active = true;
    private Boolean isCart2Active = true;
    private int money;
    private static List<Player> players;
    private DeckOfCards deck;


    public Player(String name, Cards card1, Cards card2,DeckOfCards deck) {
        this.name = name;
        this.card1 = card1; // it not necessary to take cards as param in constructor. Carts may by los from deck, but it make testing difficult.
        this.card2 = card2;
        this.deck=deck;
        this.money=0;
        id+=1;
        this.playerId=id;
    }

    public static void setGameCommunication(GameCommunication gameCommunication) {
        Player.gameCommunication = gameCommunication;
    }

    public static void setPlayers(List<Player> players) {
        Player.players = players;
    }

    //    Usa action don't requires else players reaction
    public void Us(){
        money+=1_000_000;
    }

    // LocalBusinessmen could be block with Russia so requires acceptance else players
    public void LocalBusinessmen(){
        for (Player p:players){
            if (playerId==p.getPlayerIdId()){continue;} // skip himself
            Boolean response = p.LocalBusinessmenAcceptance();
            if (response==false){
                Boolean response1= LocalBusinessmenAcceptanceBlockReply();
                if (response1==true){return;}
                if (response1==false) {// when the player checks if the opponent has russia card
                    Boolean response2=p.Check(Cards.RUSSIA); // when player wrong checks
                    if (response2==true){
                        LoseLive();
                        return;}
                }
            }
        }
        money+=2_000_000;
    }
    public void Affair(){}
    public void Russia(){}
    public void Protest(){}
    public void Media(){}
    public void Police(){}
    public void EuropeanUnion(){}

    // return false when player block using Russia card
    public Boolean LocalBusinessmenAcceptance(){
        return gameCommunication.LocalBusinessmenAcceptance(this);
    }

    public Boolean LocalBusinessmenAcceptanceBlockReply(){
        return gameCommunication.LocalBusinessmenAcceptanceBlockReply(this);

    }
    public Boolean Check(Cards card){
        if (isCart1Active==true && card1.equals(card)){ // the player has the expected card,
            // so hi takes new, next give old card back to DeckOfCards
            Cards newCard = deck.GetCard();
            deck.AddCard(card1);
            card1=newCard;
            return true;
        }
        if (isCart2Active==true && card2.equals(card)){
            Cards newCard = deck.GetCard();
            deck.AddCard(card2);
            card2=newCard;
            return true;
        }
        // the player does not have a card so he loses one live (card)
        LoseLive();
        return false;

    }
    public void LoseLive(){
        if (isCart1Active==false){isCart2Active=false;} // player lose game
        if (isCart2Active==false){isCart1Active=false;} // player lose game
        Integer cardNumber=gameCommunication.LoseLive(this);
        if (cardNumber==1){isCart1Active=false;}
        if (cardNumber==2){isCart2Active=false;}
        return;

    }



    public String getName() {
        return name;
    }

    public Cards getCard1() {
        return card1;
    }

    public Cards getCard2() {
        return card2;
    }

    public Boolean getCart1Active() {
        return isCart1Active;
    }

    public Boolean getCart2Active() {
        return isCart2Active;
    }

    public int getMoney() {
        return money;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public DeckOfCards getDeck() {
        return deck;
    }


    public int getPlayerIdId() {
        return playerId;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", name='" + name + '\'' +
                ", card1=" + card1 +
                ", card2=" + card2 +
                ", isCart1Active=" + isCart1Active +
                ", isCart2Active=" + isCart2Active +
                ", money=" + money +
                ", deck=" + deck +
                '}';
    }

    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        Player player1= new Player("palyer1",deck.GetCard(),deck.GetCard(),deck);
        System.out.println(player1.playerId);
        Player player2= new Player("palyer2",deck.GetCard(),deck.GetCard(),deck);
        System.out.println(player2.playerId);



        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        player1.setPlayers(players);
        Player.setGameCommunication(new ConsoleGame());


//        player1.Us();
//        System.out.println(player1.getMoney());

        player1.LocalBusinessmen();
        System.out.println(player1);
        player2.LocalBusinessmen();
        System.out.println(player2);
        System.out.println(player1);

    }
}
