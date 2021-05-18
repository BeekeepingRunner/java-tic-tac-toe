import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {

    public static final int FIRST_PLAYER_ID = 0;
    public static final int SECOND_PLAYER_ID = 1;

    ArrayList<Player> players;
    ArrayList<Move> moves;

    Board board = new Board();
    Commentator commentator;

    public TicTacToe(Player one, Player two) {
        players = new ArrayList<>();
        players.add(one);
        players.add(two);
        commentator = new Commentator(players);

        moves = new ArrayList<>();
    }

    public void play() {

        boolean playerOneMoves = true;
        int moveCount = 0;
        while (true)
        {
            System.out.print("Enter move coordinates (x y) (from range 0 to 2): ");
            if (playerOneMoves)
            {
                this.getPlayerMove(FIRST_PLAYER_ID);
                playerOneMoves = false;
            }
            else {
                this.getPlayerMove(SECOND_PLAYER_ID);
                playerOneMoves = true;
            }

            board.print(moves);
            System.out.println();
            commentator.print(moves);
            System.out.println();
        }
    }

    private void getPlayerMove(int playerId) {

        int x, y;
        boolean isMoveCorrect;
        Scanner scan = new Scanner(System.in);
        do {
            isMoveCorrect = true;

            // TODO: input validation
            x = scan.nextInt();
            y = scan.nextInt();

            // check if a move is in correct range
            if (x < 0 || y < 0 || x > 2 || y > 2) {
                System.out.print("Incorrect move coordinates range (0-2)! Try again: ");
                isMoveCorrect = false;
                continue;
            }

            // check if a move is a duplicate
            for (Move oldMove : moves)
            {
                if (oldMove.x == x && oldMove.y == y)
                {
                    isMoveCorrect = false;
                    System.out.print("That field is checked! Try again: ");
                    break;
                }
            }

        } while (!isMoveCorrect);

        moves.add(new Move(playerId, x, y));
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter player 1. (O mark) name: ");
        Player playerOne = new Player(scan.nextLine(), 'O');
        System.out.print("Enter player 2. (X mark) name: ");
        Player playerTwo = new Player(scan.nextLine(), 'X');


        TicTacToe game = new TicTacToe(playerOne, playerTwo);
        // System.out.println(playerOne.getId());
        // System.out.println(playerTwo.getId());
        game.play();
    }
}
