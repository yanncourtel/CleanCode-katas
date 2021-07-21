using System.Linq;

namespace Calculator.CombinationScore
{
    public class YahtzeeCombination : ICombination
    {
        //


        private bool HasGivenOccurrences(int[] dicesValues, int numberOfOccurrences)
        {
            return dicesValues.GroupBy(x => x).Any(x => x.Count() >= numberOfOccurrences);
        }

        public int GetScore(Roll.Roll roll)
        {
            var dicesValues = roll.GetDicesValues();
            return HasGivenOccurrences(dicesValues, 5) ? 50 : 0;
        }
    }


}