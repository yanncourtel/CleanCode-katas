using System;
using System.Collections.Generic;

namespace Calculator
{
    public class GenericCalculator : ICalculator
    {
        protected Dictionary<Combination, Func<Roll.Roll, int>> Combinations;

        public GenericCalculator(Dictionary<Combination, Func<Roll.Roll, int>> combinations)
        {
            Combinations = combinations;
        }

        public int Calculate(Roll.Roll roll, Combination combination)
        {
            if (!Combinations.ContainsKey(combination))
            {
                throw new InvalidOperationException();
            }

            return Combinations[combination].Invoke(roll);
        }
    }
}