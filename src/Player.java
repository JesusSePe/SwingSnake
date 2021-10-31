public class Player {
    private String name;
    private int pts;

    public Player(String name, int pts) {
        super();
        this.name = name;
        this.pts = pts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getpts() {
        return pts;
    }

    public void setpts(int pts) {
        this.pts = pts;
    }

    @Override
    public String toString() {
        return "Player: " + name + " pts: " + pts;
    }
}
