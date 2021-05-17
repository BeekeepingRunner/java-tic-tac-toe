import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BoardTest {

    private Board board;

    @Before
    public void setUp()  {
        board = new Board();
    }

    @Test
    public void printEmptyBoard() {
        board.print(new ArrayList<>());
    }
}
