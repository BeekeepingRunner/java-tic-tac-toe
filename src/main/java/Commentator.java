import java.util.ArrayList;

public class Commentator implements Printable{

    ArrayList<Player> players;

    Commentator(ArrayList<Player> players) {
        this.players = players;
    }

    @Override
    public void print(ArrayList<Move> moves) {
        assert(moves.size() > 0);

        Move move = moves.get(moves.size() - 1);    // get last move
        Player p = players.get(move.playerNum);

        StringBuilder sb = new StringBuilder("Player ")
                .append(p.getName())
                .append(" put ")
                .append(p.getMark())
                .append(" at [")
                .append(move.x)
                .append("][")
                .append(move.y)
                .append("]");

        System.out.println(sb.toString());
    }
}
