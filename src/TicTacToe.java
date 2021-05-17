import java.util.Scanner;

public class TicTacToe {

    Player playerOne;
    Player playerTwo;

    public TicTacToe(Player one, Player two) {
        playerOne = one;
        playerTwo = two;
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
