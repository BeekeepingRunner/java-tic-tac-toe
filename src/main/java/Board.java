import java.util.ArrayList;

public class Board implements Printable {

    public static final int gridDimension = 3;

    char[][] fields = new char[gridDimension][gridDimension];   // 3x3 grid

    Board() {

        for (int i = 0; i < gridDimension; ++i)
        {
            for (int j = 0; j < gridDimension; ++j)
            {
                fields[i][j] = '\f';
            }
        }
    }

    @Override
    public void print(ArrayList<Move> moves) {
        assert(moves.size() > 0);
        for (Move move : moves)
        {
            switch (move.playerNum)
            {
                case TicTacToe.FIRST_PLAYER_ID:
                    fields[move.x][move.y] = 'O';
                case TicTacToe.SECOND_PLAYER_ID:
                    fields[move.x][move.y] = 'X';
            }
        }

        for (int i = 0; i < gridDimension; ++i)
        {
            // e.g. print X|O|X
            System.out.print(fields[i][gridDimension - 3] + "|");
            System.out.print(fields[i][gridDimension - 2] + "|");
            System.out.println(fields[i][gridDimension - 1]);

            if (i < 2)
                System.out.println("-----");
        }
    }
}
