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
        if(width() <= 0) throw new IllegalArgumentException(format(
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
    
    public void draw(Graphics graphics) {
        //top horizontal line
        graphics.drawLine( 
                topLeft.x, topLeft.y,
                bottomRight.x, topLeft.y
        );
        //bottom horizontal line
        graphics.drawLine(
                topLeft.x, bottomRight.y,
                bottomRight.x, bottomRight.y
        );
        //left vertical line
        graphics.drawLine(
                topLeft.x, topLeft.y,
                topLeft.x, topLeft.y - heigth()
        );
        //right vertical line
        graphics.drawLine(
                bottomRight.x, bottomRight.y - heigth(),
                bottomRight.x, bottomRight.y
        );
    }
    
    private int width() {
        return bottomRight.x - topLeft.x;
    }

    private int heigth() {
        return topLeft.y - bottomRight.y;
    }

}
