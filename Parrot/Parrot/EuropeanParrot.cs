namespace Parrot
{
    public class EuropeanParrot: BaseParrot
    {
        private readonly double BaseSpeed = 12.0;

        public EuropeanParrot()
        {
        }

        public override double GetSpeed()
        {
            return BaseSpeed;
        }
    }
}