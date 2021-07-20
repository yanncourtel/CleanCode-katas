using System;
using System.Collections.Generic;
using System.Linq;
using GenericCalculator.Combinations;

namespace GenericCalculator
{
    public class SimpleYahtzeeCalculator : ICalculator
    {
        private Dictionary<Combination,Func<int>> _combinations;

        public SimpleYahtzeeCalculator(Dictionary<Combination, Func<int>> combinations)
        {
            _combinations = combinations;
        }


        public int Calculate(Roll.Roll roll, Combination combination)
        {
            // return combination switch
            // {
            //     Combination.Ones => new SimpleSumValueCombination((int)Combination.Ones).GetScore(roll),
            //     Combination.Twos => new SimpleSumValueCombination((int)Combination.Twos).GetScore(roll),
            //     Combination.Threes => new SimpleSumValueCombination((int)Combination.Threes).GetScore(roll),
            //     Combination.Fours => new SimpleSumValueCombination((int)Combination.Fours).GetScore(roll),
            //     Combination.Fives => new SimpleSumValueCombination((int)Combination.Fives).GetScore(roll),
            //     Combination.Sixes => new SimpleSumValueCombination((int)Combination.Sixes).GetScore(roll),
            //     Combination.Yahtzee => new YahtzeeCombination().GetScore(roll),
            //     _ => throw new InvalidOperationException()
            // };
            return _combinations[combination].Invoke();
        }

 
    }
}