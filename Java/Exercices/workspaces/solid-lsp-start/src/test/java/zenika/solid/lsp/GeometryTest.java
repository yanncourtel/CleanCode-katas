package zenika.solid.lsp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeometryTest {
    
    @Test public void area_should_be_height_times_width_1() {
        area_should_be_height_times_width(new Rectangle());
    }
    
    @Test public void area_should_be_height_times_width_2() {
        area_should_be_height_times_width(new Square());
    }
    
    private void area_should_be_height_times_width(Rectangle rect) {
        rect.setWidth(5);
        rect.setHeight(4);
        assertEquals(20, rect.getArea());
    }
    
}
