using System;
using System.Linq;

namespace GenericCalculator
{
    public class SimpleYahtzeeCalculator : ICalculator
    {


        public int Calculate(Roll.Roll roll, Combination.Combination combination)
        {
            var dicesValues = roll.GetDicesValues();

            return combination switch
            {
                Combination.Combination.Ones => new SimpleSumValueCombination(1).GetScore(roll),
                Combination.Combination.Twos => dicesValues.Where(x => x == 2).Sum(),
                Combination.Combination.Threes => dicesValues.Where(x => x == 3).Sum(),
                Combination.Combination.Fours => dicesValues.Where(x => x == 4).Sum(),
                Combination.Combination.Fives => dicesValues.Where(x => x == 5).Sum(),
                Combination.Combination.Sixes => dicesValues.Where(x => x == 6).Sum(),
                Combination.Combination.Yahtzee => new YahtzeeCombination().GetScore(roll),
                _ => throw new InvalidOperationException()
            };
        }

 
    }
}