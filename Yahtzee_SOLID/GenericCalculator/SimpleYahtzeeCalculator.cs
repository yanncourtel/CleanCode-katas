using System;

namespace GenericCalculator
{
    public class SimpleYahtzeeCalculator : ICalculator
    {
        public int Calculate(Roll.Roll roll, Combination.Combination combination)
        {
            throw new InvalidOperationException();
        }
    }
}