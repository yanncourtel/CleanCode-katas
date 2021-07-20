namespace Parrot
{
    public class NorwegianBlueParrot : BaseParrot
    {
        protected readonly bool _isNailed;
        protected readonly double _voltage;

        public NorwegianBlueParrot(bool isNailed, double voltage)
        {
            _isNailed = isNailed;
            _voltage = voltage;
        }

        public override double GetSpeed()
        {
            return _isNailed ? 0 : GetBaseSpeed(_voltage);
        }
    }
}