using System;
using FluentAssertions;
using GenericCalculator.Roll;
using Xunit;

namespace Tests
{
    public class DiceShould
    {
        [Fact]
        public void Have_A_Value_Between_1_And_6()
        {
            // arrange
            int expectedValue = 1;
            
            // act
            var dice = new Dice(expectedValue);
            
            // assert
            dice.Value.Should().Be(expectedValue);

        }
        
        [Fact]
        public void Not_Have_A_Value_Lower_Than_1()
        {
            // arrange
            // act
            Action result = ()=> new Dice(0);
            
            // assert
            result.Should().Throw<InvalidDiceException>()
                .WithMessage("A dice value must be between one and six");

        }
        
        [Fact]
        public void Not_Have_A_Value_Higher_Than_6()
        {
            // arrange
            // act
            Action result = ()=> new Dice(7);
            
            // assert
            result.Should().Throw<InvalidDiceException>();

        }
    }
}