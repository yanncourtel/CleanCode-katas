using System;
using System.Linq;

namespace GenericCalculator
{
    public class YahtzeeCalculator : ICalculator
    {
        public int Calculate(Roll.Roll roll, Combination.Combination combination)
        {
            if (roll == null)
            {
                throw new ArgumentNullException();
            }

            var dicesValues = roll.GetDicesValues();

            return combination switch
            {
                Combination.Combination.Ones => dicesValues.Where(x => x == 1).Sum(),
                Combination.Combination.Twos => dicesValues.Where(x => x == 2).Sum(),
                Combination.Combination.Threes => dicesValues.Where(x => x == 3).Sum(),
                Combination.Combination.Fours => dicesValues.Where(x => x == 4).Sum(),
                Combination.Combination.Fives => dicesValues.Where(x => x == 5).Sum(),
                Combination.Combination.Sixes => dicesValues.Where(x => x == 6).Sum(),
                Combination.Combination.Chance => dicesValues.Sum(),
                Combination.Combination.LargeStraight => IsLargeStraight(dicesValues) ? 40 : 0,
                Combination.Combination.SmallStraight => IsSmallStraight(dicesValues) ? 30 : 0,
                Combination.Combination.Yahtzee => HasGivenOccurrences(dicesValues, 5) ? 50 : 0,
                Combination.Combination.Square => HasGivenOccurrences(dicesValues, 4) ? dicesValues.Sum() : 0,
                Combination.Combination.ThreeOfAKind => HasGivenOccurrences(dicesValues, 3) ? dicesValues.Sum() : 0,
                Combination.Combination.FullHouse => IsFullHouse(dicesValues) ? 25 : 0,
                _ => throw new ArgumentOutOfRangeException()
            };
        }

        private bool IsFullHouse(int[] dicesValues)
        {
            return HasGivenOccurrences(dicesValues, 5)
                   || (dicesValues.GroupBy(x => x).Any(x => x.Count() == 3) && dicesValues.Distinct().Count() == 2);
        }

        private bool HasGivenOccurrences(int[] dicesValues, int numberOfOccurrences)
        {
            return dicesValues.GroupBy(x => x).Any(x => x.Count() >= numberOfOccurrences);
        }

        private bool IsSmallStraight(int[] dicesValues)
        {
            return dicesValues.Intersect(new int[] { 1, 2, 3, 4 }).Count() == 4 ||
                   dicesValues.Intersect(new int[] { 2, 3, 4, 5 }).Count() == 4 ||
                   dicesValues.Intersect(new int[] { 3, 4, 5, 6 }).Count() == 4;
        }

        private bool IsLargeStraight(int[] dicesValues)
        {
            return dicesValues.Intersect(new int[] { 1, 2, 3, 4, 5 }).Count() == 5 ||
                   dicesValues.Intersect(new int[] { 2, 3, 4, 5, 6 }).Count() == 5;
        }
    }
}