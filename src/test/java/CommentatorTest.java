import org.junit.Before;

import java.util.ArrayList;

public class CommentatorTest {

    private ArrayList<Move> moves;
    private ArrayList<Player> players;
    private Commentator commentator;

    @Before
    void setUp() {
        players = new ArrayList<>();
        players.add(new Player("P1", 'O'));
        players.add(new Player("P2", 'X'));
        commentator = new Commentator(players);
    }
}
