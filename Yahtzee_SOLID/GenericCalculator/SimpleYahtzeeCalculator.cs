using System;
using System.Linq;

namespace GenericCalculator
{
    public class SimpleYahtzeeCalculator : ICalculator
    {
        private readonly ICombination[] combinations;

        public SimpleYahtzeeCalculator(params ICombination[] combinations)
        {
            this.combinations = combinations;
        }

        public int Calculate(Roll.Roll roll, Combination.Combination combination)
        {
            var dicesValues = roll.GetDicesValues();

            return combination switch
            {
                Combination.Combination.Ones => dicesValues.Where(x => x == 1).Sum(),
                Combination.Combination.Twos => dicesValues.Where(x => x == 2).Sum(),
                Combination.Combination.Threes => dicesValues.Where(x => x == 3).Sum(),
                Combination.Combination.Fours => dicesValues.Where(x => x == 4).Sum(),
                Combination.Combination.Fives => dicesValues.Where(x => x == 5).Sum(),
                Combination.Combination.Sixes => dicesValues.Where(x => x == 6).Sum(),
                Combination.Combination.Yahtzee => HasGivenOccurrences(dicesValues, 5) ? 50 : 0,
                _ => throw new InvalidOperationException()
            };
        }

        private bool HasGivenOccurrences(int[] dicesValues, int numberOfOccurrences)
        {
            return dicesValues.GroupBy(x => x).Any(x => x.Count() >= numberOfOccurrences);
        }
    }
}