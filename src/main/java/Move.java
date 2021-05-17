public class Move {

    int playerNum;

    // move coordinates - range = {0, 1, 2}
    int x;
    int y;

    Move(int playerNum, int x, int y) {
        this.playerNum = playerNum;
        this.x = x;
        this.y = y;
    }
}
