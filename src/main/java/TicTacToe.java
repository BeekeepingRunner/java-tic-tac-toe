import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {

    private static final int FIRST = 0;
    private static final int SECOND = 1;

    ArrayList<Player> players;
    ArrayList<Move> moves;

    Board board = new Board();
    Commentator commentator;

    public TicTacToe(Player one, Player two) {
        players = new ArrayList<>();
        players.add(one);
        players.add(two);
        commentator = new Commentator(players);
    }

    public void play() {

        boolean playerOneMoves = true;
        int moveCount = 0;
        while (true)
        {
            System.out.println("Enter field coordinates (x y): ");
            if (playerOneMoves)
            {
                this.getPlayerMove(players.get(FIRST).getId());
                playerOneMoves = false;
            }
            else {
                this.getPlayerMove(players.get(SECOND).getId());
                playerOneMoves = true;
            }

            board.print(this.moves);
            System.out.println();
            commentator.print(moves);
            System.out.println();
        }
    }

    private void getPlayerMove(int playerId) {

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter player 1. (O mark) name: ");
        Player playerOne = new Player(scan.nextLine(), 'O');
        System.out.println("Enter player 2. (X mark) name: ");
        Player playerTwo = new Player(scan.nextLine(), 'X');
        scan.close();

        TicTacToe game = new TicTacToe(playerOne, playerTwo);
        // System.out.println(playerOne.getId());
        // System.out.println(playerTwo.getId());
        game.play();
    }
}
