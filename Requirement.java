public abstract class Requirement {
    
    protected int x;
    protected int y;

    public Requirement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getter methods
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
