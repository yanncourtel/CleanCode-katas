using System;

namespace Parrot
{
    public class AfricanParrot : BaseParrot
    {
        private int _numberOfCoconuts;
        private const int LoadFactor = 9;

        public AfricanParrot(int numberOfCoconuts)
        {
            _numberOfCoconuts = numberOfCoconuts;
        }

        public override double GetSpeed()
        {
            return Math.Max(0, GetBaseSpeed() - LoadFactor * _numberOfCoconuts);
        }
    }
}