using GenericCalculator.Combinations;

namespace GenericCalculator
{
    public interface ICalculator
    {
        int Calculate(Roll.Roll roll, Combination combination);
    }
}