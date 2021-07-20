namespace SOLID.Liskov
{
    public class Square : IPolygonArea
    {
        private int _side;

        public Square(int side)
        {
            _side = side;
        }
        
        public int Area => _side * _side;
    }
}