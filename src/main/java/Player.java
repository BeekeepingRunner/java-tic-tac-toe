public class Player {

    String name;
    int id;
    char mark;

    private static int nextId = 0;

    Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
        id = nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getMark() {
        return mark;
    }

    public void setMark(char mark) {
        this.mark = mark;
    }

    public int getId() {
        return this.id;
    }
}
