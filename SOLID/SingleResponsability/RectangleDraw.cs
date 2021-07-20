using System.Drawing;

namespace SOLID.SingleResponsability
{
    public class RectangleDraw:IDraw
    {
        private Rectangle _rectangle;

        public RectangleDraw(Rectangle rectangle)
        {
            _rectangle = rectangle;
        }

        public void Draw(System.Drawing.Graphics graphics)
        {
            //top horizontal line
            graphics.DrawLine(Pens.Black,
                _rectangle.TopLeft.X, _rectangle.TopLeft.Y,
                _rectangle.BottomRight.X, _rectangle.TopLeft.Y
            );
            //bottom horizontal line
            graphics.DrawLine(Pens.Black,
                _rectangle.TopLeft.X, _rectangle.BottomRight.Y,
                _rectangle.BottomRight.X, _rectangle.BottomRight.Y
            );
            //left vertical line
            graphics.DrawLine(Pens.Black,
                _rectangle.TopLeft.X, _rectangle.TopLeft.Y,
                _rectangle.TopLeft.X, _rectangle.TopLeft.Y - _rectangle.Heigth
            );
            //right vertical line
            graphics.DrawLine(Pens.Black,
                _rectangle.BottomRight.X, _rectangle.BottomRight.Y - _rectangle.Heigth,
                _rectangle.BottomRight.X, _rectangle.BottomRight.Y
            );
        }
    }
}