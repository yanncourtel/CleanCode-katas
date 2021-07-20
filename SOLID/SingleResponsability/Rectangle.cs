using System;
using System.Drawing;

namespace SOLID.SingleResponsability
{
    public class Rectangle
    {
        public Point TopLeft { get; }
        public Point BottomRight { get; }

        public Rectangle(Point topLeft, Point bottomRight)
        {
            this.TopLeft = topLeft;
            this.BottomRight = bottomRight;
            if (Width <= 0) throw new ArgumentException($"topLeft {topLeft} is not to the left of bottomRight ({bottomRight})");
            if (Heigth <= 0) throw new ArgumentException($"topLeft({topLeft}) is not to the top of bottomRight({bottomRight})");
        }

        public int Perimeter => 2 * (Width + Heigth);

        public int Area => Width * Heigth;

        

        private int Width => BottomRight.X - TopLeft.X;

        public int Heigth => TopLeft.Y - BottomRight.Y;
    }


}
