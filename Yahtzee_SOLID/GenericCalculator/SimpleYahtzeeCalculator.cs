using System;
using System.Collections.Generic;
using System.Linq;
using GenericCalculator.Combinations;

namespace GenericCalculator
{
    public class SimpleYahtzeeCalculator : ICalculator
    {
        private Dictionary<Combination, Func<Roll.Roll, int>> _combinations = new Dictionary<Combination, Func<Roll.Roll, int>>();

        public SimpleYahtzeeCalculator()
        {
            _combinations.Add(Combination.Ones, roll => new SimpleSumValueCombination((int)Combination.Ones).GetScore(roll));
            _combinations.Add(Combination.Twos, roll => new SimpleSumValueCombination((int)Combination.Twos).GetScore(roll));
            _combinations.Add(Combination.Threes, roll => new SimpleSumValueCombination((int)Combination.Threes).GetScore(roll));
            _combinations.Add(Combination.Fours, roll => new SimpleSumValueCombination((int)Combination.Fours).GetScore(roll));
            _combinations.Add(Combination.Fives, roll => new SimpleSumValueCombination((int)Combination.Fives).GetScore(roll));
            _combinations.Add(Combination.Sixes, roll => new SimpleSumValueCombination((int)Combination.Sixes).GetScore(roll));
            _combinations.Add(Combination.Yahtzee, roll => new YahtzeeCombination().GetScore(roll));
        }


        public int Calculate(Roll.Roll roll, Combination combination)
        {
            if (!_combinations.ContainsKey(combination))
            {
                throw new InvalidOperationException();
            }

            return _combinations[combination].Invoke(roll);
        }


    }
}