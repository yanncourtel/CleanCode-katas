using System;

namespace GenericCalculator.Roll
{
    public class InvalidRollException : Exception
    {
        public InvalidRollException() : base("A roll must have 5 dices")
        {
        }
    }
}