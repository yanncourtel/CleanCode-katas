using System;
using System.Drawing;

namespace SOLID.SingleResponsability
{
    public class Rectangle
    {
        private readonly Point topLeft;
        private readonly Point bottomRight;

        public Rectangle(Point topLeft, Point bottomRight)
        {
            this.topLeft = topLeft;
            this.bottomRight = bottomRight;
            if (Width <= 0) throw new ArgumentException($"topLeft {topLeft} is not to the left of bottomRight ({bottomRight})");
            if (Heigth <= 0) throw new ArgumentException($"topLeft({topLeft}) is not to the top of bottomRight({bottomRight})");
        }

        public int Perimeter => 2 * (Width + Heigth);

        public int Area => Width * Heigth;

        public void Draw(System.Drawing.Graphics graphics)
        {
            //top horizontal line
            graphics.DrawLine(Pens.Black,
                topLeft.X, topLeft.Y,
                bottomRight.X, topLeft.Y
            );
            //bottom horizontal line
            graphics.DrawLine(Pens.Black,
                topLeft.X, bottomRight.Y,
                bottomRight.X, bottomRight.Y
            );
            //left vertical line
            graphics.DrawLine(Pens.Black,
                topLeft.X, topLeft.Y,
                topLeft.X, topLeft.Y - Heigth
            );
            //right vertical line
            graphics.DrawLine(Pens.Black,
                bottomRight.X, bottomRight.Y - Heigth,
                bottomRight.X, bottomRight.Y
            );
        }

        private int Width => bottomRight.X - topLeft.X;

        private int Heigth => topLeft.Y - bottomRight.Y;
    }


}
