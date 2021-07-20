namespace GenericCalculator.Roll
{
    public class Dice
    {
        public int Value { get; }

        public Dice(int dice)
        {
            Value = dice >= 1 && dice <= 6 ? dice : throw new InvalidDiceException("A dice value must be between one and six");
        }
    }
}