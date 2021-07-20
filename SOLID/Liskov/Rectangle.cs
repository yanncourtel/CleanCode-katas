namespace SOLID.Liskov
{
    public class Rectangle : IPolygonArea
    {
        public virtual int Width { get; set; }
        public virtual int Height { get; set; }

        public virtual int Area => Height * Width;
    }
}