package zenika.solid.lsp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeometryTest {

    @Test public void rectangle_perimeter_should_be_height_times_width() {
        Rectangle rect = new Rectangle();
        rect.setWidth(5);
        rect.setHeight(4);
        assertEquals(20, rect.getArea());
    }

    @Test public void square_perimeter_should_be_side_squared() {
        Square square = new Square();
        square.setSide(5);
        assertEquals(25, square.getArea());
    }
}
