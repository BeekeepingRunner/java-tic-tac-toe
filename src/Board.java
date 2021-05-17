import java.util.ArrayList;

public class Board {

    char[][] fields; // 3x3 grid

    Board() {
        fields = new char[3][3];

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                fields[i][j] = '\f';
            }
        }
    }

}
