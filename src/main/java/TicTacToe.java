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

        board.print(moves);
        System.out.println();

        boolean playerOneMoves = true;
        int moveCount = 0;
        while (true)
        {
            if (playerOneMoves)
            {
                this.getPlayerMove(FIRST_PLAYER_ID);
            }
            else {
                this.getPlayerMove(SECOND_PLAYER_ID);
            }

            System.out.println();
            board.print(moves);
            System.out.println();
            commentator.print(moves);
            System.out.println();

            // let's check if the last move was a winning move!
            if (hasWon(playerOneMoves))
            {
                if (playerOneMoves) {
                    System.out.println("\n" + players.get(FIRST_PLAYER_ID).getName() + " won!!!");
                } else {
                    System.out.println("\n" + players.get(SECOND_PLAYER_ID).getName() + " won!!!");
                }
                return;
            }

            if (board.isFull()) {
                System.out.println("\nThe board is full, so it's a draw. :)");
                return;
            }

            playerOneMoves = !playerOneMoves;
        }
    }

    private void getPlayerMove(int playerId) {

        System.out.println(players.get(playerId).getName() + " moves now...");
        System.out.println("Enter move coordinates (from range 0 to 2)");

        int x, y;
        boolean isMoveCorrect;
        do {
            isMoveCorrect = true;

            System.out.print("x: ");
            x = getCoordinate();
            System.out.print("y: ");
            y = getCoordinate();

            // check if a move is in correct range
            if (x < 0 || y < 0 || x > 2 || y > 2) {
                System.out.println("Incorrect move coordinates range (0-2)! Try again: ");
                isMoveCorrect = false;
                continue;
            }

            // check if a move is a duplicate
            for (Move oldMove : moves)
            {
                if (oldMove.x == x && oldMove.y == y)
                {
                    isMoveCorrect = false;
                    System.out.println("That field is checked! Try again");
                    break;
                }
            }
        } while (!isMoveCorrect);

        moves.add(new Move(playerId, x, y));
    }

    private int getCoordinate() {

        Scanner scan = new Scanner(System.in);
        int x = 0;

        while (true) {
            try {
                x = Integer.parseInt(scan.nextLine());
                break;
            } catch (NumberFormatException ex) {
                System.out.print("Invalid input, try again: ");
            }
        }
        return x;
    }

    private boolean hasWon(boolean playerOneMoved) {

        if (board.hasThreeInAline(playerOneMoved)) {
            return true;
        } else
            return false;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter player 1. (O mark) name: ");
        Player playerOne = new Player(scan.nextLine(), 'O');
        System.out.print("Enter player 2. (X mark) name: ");
        Player playerTwo = new Player(scan.nextLine(), 'X');
        System.out.println();

        TicTacToe game = new TicTacToe(playerOne, playerTwo);
        // System.out.println(playerOne.getId());
        // System.out.println(playerTwo.getId());
        game.play();
    }
}
