package zenika.solid.lsp;

public class Square {

    private int side;

    public void setSide(int side) {
        this.side = side;
    }


    public int getArea() {
        return side * side;
    }
}
