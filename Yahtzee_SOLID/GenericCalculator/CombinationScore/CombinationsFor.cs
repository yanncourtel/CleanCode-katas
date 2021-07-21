using System;
using System.Collections.Generic;

namespace Calculator.CombinationScore
{
    public static class CombinationsFor
    {
        public static Dictionary<Combination, Func<Roll.Roll, int>> SimpleYahtzee => CombinationsForSimpleYahtzee();

        private static Dictionary<Combination, Func<Roll.Roll, int>> CombinationsForSimpleYahtzee()
        {
            var combinations = new Dictionary<Combination, Func<Roll.Roll, int>>
            {
                { Combination.Ones, roll => new SimpleSumValueCombination((int)Combination.Ones).GetScore(roll) },
                { Combination.Twos, roll => new SimpleSumValueCombination((int)Combination.Twos).GetScore(roll) },
                { Combination.Threes, roll => new SimpleSumValueCombination((int)Combination.Threes).GetScore(roll) },
                { Combination.Fours, roll => new SimpleSumValueCombination((int)Combination.Fours).GetScore(roll) },
                { Combination.Fives, roll => new SimpleSumValueCombination((int)Combination.Fives).GetScore(roll) },
                { Combination.Sixes, roll => new SimpleSumValueCombination((int)Combination.Sixes).GetScore(roll) },
                { Combination.Yahtzee, roll => new YahtzeeCombination().GetScore(roll) }
            };

            return combinations;
        }

        //Add the Yahtzee combinations and other games
    }
}