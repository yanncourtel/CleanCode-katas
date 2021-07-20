using System;

namespace GenericCalculator.Roll
{
    public class InvalidDiceException : Exception
    {
        public InvalidDiceException() : base("Your dices are invalid")
        {
        }

        public InvalidDiceException(string message) : base(message)
        {
        }
    }
}