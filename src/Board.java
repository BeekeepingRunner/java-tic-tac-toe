import java.util.ArrayList;

public class Board {

    public static final int gridDimension = 3;

    char[][] fields = new char[gridDimension][gridDimension];   // 3x3 grid

    Board() {

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                fields[i][j] = '\f';
            }
        }
    }
}
