import java.util.Scanner;

public class ConsoleGame implements  GameCommunication{
    @Override
    public Boolean LocalBusinessmenAcceptance(Player player) {

        while (true){
            System.out.println(player.getName() + " do you accept the Local Businessmen move:  Y/N");
            Scanner scan = new Scanner(System.in);
            String sc = scan.nextLine();
            System.out.println(sc.toCharArray());
            if (sc.toLowerCase().equals("n")){return false;}
            if (sc.toLowerCase().equals("y")){return true;}

            System.out.println("wrong answer");
    }
    }

    @Override
    public Integer LoseLive(Player player) {
        while (true){
            System.out.println(player.getName() + " lose one card, choose which  1/2");
            System.out.println("1 : " + player.getCard1());
            System.out.println("2 : " + player.getCard2());
            Scanner scan = new Scanner(System.in);
            String sc = scan.nextLine();
            System.out.println(sc.toCharArray());
            if (sc.toLowerCase().equals("1")){return 1;}
            if (sc.toLowerCase().equals("2")){return 2;}

            System.out.println("wrong answer");
        }
    }

    @Override
    public Boolean LocalBusinessmenAcceptanceBlockReply(Player player) {
        while (true){
            System.out.println(player.getName() + " do you accept blocking by russia  Y/N");
            Scanner scan = new Scanner(System.in);
            String sc = scan.nextLine();
            System.out.println(sc.toCharArray());
            if (sc.toLowerCase().equals("n")){return false;}
            if (sc.toLowerCase().equals("y")){return true;}

            System.out.println("wrong answer");
        }
    }

}




