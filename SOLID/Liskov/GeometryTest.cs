using Xunit;

namespace SOLID.Liskov
{
    public class GeometryTest
    {
        [Fact]
        public void Area_should_be_height_times_width_1()
        {
            Rectangle rect = new Rectangle();
            rect.Width = 5;
            rect.Height = 4;
            Assert.Equal(20, rect.Area);
        }

        [Fact]
        public void Area_should_be_height_times_width_2()
        {
            Square rect = new Square(5);
            Assert.Equal(25, rect.Area);
        }
    }
}