package zenika.solid.srp;

import java.awt.*;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

public class Rectangle
{
    private final Point topLeft, bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = requireNonNull(topLeft);
        this.bottomRight = requireNonNull(bottomRight);
        if(width() <=0 ) throw new IllegalArgumentException(format(
                "topLeft(%s) is not to the left of bottomRight(%s)",
                topLeft, bottomRight
        ));
        if(heigth() <= 0) throw new IllegalArgumentException(format(
                "topLeft(%s) is not to the top of bottomRight(%s)",
                topLeft, bottomRight
        )); 
    }

    public int perimeter() {
        return 2 * (width() + heigth());
    }

    public int area() {
        return width() * heigth();
    }
    
    private int width() {
        return bottomRight.x - topLeft.x;
    }

    private int heigth() {
        return topLeft.y - bottomRight.y;
    }

    public int topLeftX() {
        return topLeft.x;
    }

    public int topLeftY() {
        return topLeft.y;
    }
    
    public int bottomRightX() {
        return bottomRight.x;
    }

    public int bottomRightY() {
        return bottomRight.y;
    }

    public int topRightX() {
        return bottomRightX();
    }

    public int topRightY() {
        return topLeftY();
    }

    public int bottomLeftX() {
        return topLeftX();
    }

    public int bottomLeftY() {
        return bottomRightY();
    }

}
