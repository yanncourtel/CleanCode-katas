using System;

namespace Trivia
{
    public class Player
    {
        public Player(string name, int place, int purse, bool isInPenaltyBox)
        {
            Name = name;
            Place = place;
            Purse = purse;
            IsInPenaltyBox = isInPenaltyBox;
        }

        public string Name { get; set; }
        public int Place { get; set; }
        public int Purse { get; set; }
        public bool IsInPenaltyBox { get; private set; }

        public void GoToPenaltyBox()
        {
            IsInPenaltyBox = true;
        }

        public void GetOutOfPenaltyBox()
        {
            IsInPenaltyBox = false;
        }
    }
}