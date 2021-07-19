package zenika.solid.lsp;

public class Square extends Rectangle {

    @Override
    public void setHeight(int height) {
        setSide(height);
    }

    @Override
    public void setWidth(int width) {
        setSide(width);
    }

    public void setSide(int side) {
        super.setHeight(side);
        super.setWidth(side);
    }
    
    public int getSide() {
        return getHeight();
    }
        
}
