import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {

    ArrayList<Player> players;

    Board board = new Board();
    Commentator commentator;

    public TicTacToe(Player one, Player two) {
        players.add(one);
        players.add(two);
        commentator = new Commentator(players);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter player 1. (O mark) name: ");
        Player playerOne = new Player(scan.nextLine(), 'O');
        System.out.println("Enter player 2. (X mark) name: ");
        Player playerTwo = new Player(scan.nextLine(), 'X');

        TicTacToe game = new TicTacToe(playerOne, playerTwo);

        
    }
}
