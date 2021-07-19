package zenika.solid.srp;

import java.awt.*;

import static java.util.Objects.requireNonNull;

public class RectangleWidget
{
    private final Rectangle rectangle;

    public RectangleWidget(Rectangle rectangle) {
        this.rectangle = requireNonNull(rectangle);
    }

    public void draw(Graphics graphics) {
        //top horizontal line
        graphics.drawLine(
                rectangle.topLeftX(), rectangle.topLeftY(),
                rectangle.topRightX(), rectangle.topRightY()
        );
        //bottom horizontal line
        graphics.drawLine(
                rectangle.bottomLeftX(), rectangle.bottomLeftY(),
                rectangle.bottomRightX(), rectangle.bottomRightY()
        );
        //left vertical line
        graphics.drawLine(
                rectangle.topLeftX(), rectangle.topLeftY(),
                rectangle.bottomLeftX(), rectangle.bottomLeftY()
        );
        //right vertical line
        graphics.drawLine(
                rectangle.topRightX(), rectangle.topRightY(),
                rectangle.bottomRightX(), rectangle.bottomRightY()
        );
    }

}
