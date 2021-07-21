using System;

using Calculator;
using Calculator.Roll;

using FluentAssertions;

using Xunit;

namespace Tests
{
    public class SimpleCalculatorShould
    {
        private readonly ICalculator simpleYahtzeeCalculator = new SimpleYahtzeeCalculator();

        [Fact]
        public void Simple_Yahtzee_Calculator_Should_Have_Only_Upper_Combination()
        {
            // arrange 
            var dices = new Dice[]
            {new Dice(1), new Dice(1), new Dice(1), new Dice(1), new Dice(1)};
            var roll = new Roll(dices);

            // act
            Action action = () => simpleYahtzeeCalculator.Calculate(roll, Combination.FullHouse);

            // assert
            action.Should().Throw<InvalidOperationException>();
        }

        [Theory]
        [InlineData(1, 1, 1, 1, 1, Combination.Ones, 5)]
        [InlineData(1, 1, 1, 1, 2, Combination.Ones, 4)]
        [InlineData(1, 1, 1, 1, 2, Combination.Twos, 2)]
        [InlineData(1, 1, 1, 1, 3, Combination.Threes, 3)]
        [InlineData(1, 1, 1, 1, 4, Combination.Fours, 4)]
        [InlineData(1, 1, 1, 1, 5, Combination.Fives, 5)]
        [InlineData(1, 1, 1, 1, 6, Combination.Sixes, 6)]
        [InlineData(1, 1, 1, 1, 1, Combination.Yahtzee, 50)]
        [InlineData(1, 1, 1, 1, 2, Combination.Yahtzee, 0)]
        public void Simple_Yahtzee_Calculator_Calculates_Upper_Combination(int dice1, int dice2, int dice3, int dice4,
            int dice5, Combination combination, int expectedScore)
        {
            // arrange 
            var dices = new Dice[]
            {new Dice(dice1), new Dice(dice2), new Dice(dice3), new Dice(dice4), new Dice(dice5)};
            var roll = new Roll(dices);

            // act
            var result = simpleYahtzeeCalculator.Calculate(roll, combination);

            // assert
            result.Should().Be(expectedScore);
        }
    }
}