using System;

namespace Parrot
{
    public abstract class BaseParrot
    {
        public BaseParrot()
        {
        }

        public abstract double GetSpeed();

        protected double GetBaseSpeed(double voltage)
        {
            return Math.Min(24.0, voltage * GetBaseSpeed());
        }

        protected double GetBaseSpeed()
        {
            return 12.0;
        }
    }
}