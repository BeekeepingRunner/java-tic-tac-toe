import java.util.ArrayList;

public class Board implements Printable {

    public static final int gridDimension = 3;
    public static final char PLAYER_ONE_MARK = 'O';
    public static final char PLAYER_TWO_MARK = 'X';

    char[][] fields = new char[gridDimension][gridDimension];   // 3x3 grid

    Board() {

        for (int i = 0; i < gridDimension; ++i)
        {
            for (int j = 0; j < gridDimension; ++j)
            {
                fields[i][j] = ' ';
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
                    fields[move.x][move.y] = PLAYER_ONE_MARK;
                    break;
                case TicTacToe.SECOND_PLAYER_ID:
                    fields[move.x][move.y] = PLAYER_TWO_MARK;
                    break;
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

    public boolean hasThreeInAline(boolean playerOneMoved) {

        char mark;
        if (playerOneMoved) {
            mark = PLAYER_ONE_MARK;
        } else {
            mark = PLAYER_TWO_MARK;
        }

        if (hasThreeHorizontally(mark)
        || hasThreeVertically(mark)
        || hasThreeAslope(mark)) {
            return true;
        }

        return false;
    }

    private boolean hasThreeHorizontally(char mark) {

        int marksInArow;
        for (int row = 0; row < gridDimension; ++row)
        {
            marksInArow = 0;
            for (int col = 0; col < gridDimension; ++col)
            {
                if (fields[row][col] == mark) {
                    ++marksInArow;
                } else break;
            }

            if (marksInArow == 3) {
                return true;
            }
        }

        return false;
    }

    private boolean hasThreeVertically(char mark) {

        int marksInAcol;
        for (int col = 0; col < gridDimension; ++col)
        {
            marksInAcol = 0;
            for (int row = 0; row < gridDimension; ++row)
            {
                if (fields[col][row] == mark)
                    ++marksInAcol;
                else break;
            }

            if (marksInAcol == 3) {
                return true;
            }
        }

        return false;
    }

    private boolean hasThreeAslope(char mark) {

        int marksInALine = 0;
        for (int row = 0, col = 0; row < gridDimension; ++row, ++col)
        {
            if (fields[row][col] == mark) {
                ++marksInALine;
            } else break;
        }

        if (marksInALine == 3) {
            return true;
        }

        marksInALine = 0;
        for (int row = 0, col = gridDimension - 1; row < gridDimension; ++row, --col)
        {
            if (fields[row][col] == mark) {
                ++marksInALine;
            } else break;
        }

        if (marksInALine == 3) {
            return true;
        }

        return false;
    }
}
