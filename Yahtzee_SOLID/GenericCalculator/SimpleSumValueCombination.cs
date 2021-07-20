using System.Linq;

namespace GenericCalculator
{
    public class SimpleSumValueCombination : ICombination
    {
        private readonly int _diceValue;

        public SimpleSumValueCombination(int diceValue)
        {
            _diceValue = diceValue;
        }

        public int GetScore(Roll.Roll roll)
        {
            var dicesValues = roll.GetDicesValues();

            return dicesValues.Where(x => x == _diceValue).Sum();
        }
    }
}