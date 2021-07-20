using System;
using System.Collections.Generic;
using System.Linq;

namespace Trivia
{
    public class Game
    {
        private const int MaxPlayersNumber = 6;
        private const int MaxPlacesNumber = 12;
        private const int ScoreToWin = 6;
        private readonly List<Player> _players = new List<Player>();

        private readonly LinkedList<string> _popQuestions = new LinkedList<string>();
        private readonly LinkedList<string> _scienceQuestions = new LinkedList<string>();
        private readonly LinkedList<string> _sportsQuestions = new LinkedList<string>();
        private readonly LinkedList<string> _rockQuestions = new LinkedList<string>();

        private int _currentPlayer;
        private Player CurrentPlayer => _players[_currentPlayer];

        public bool IsPlayable() => (HowManyPlayers() >= 2);

        public Game()
        {
            for (var i = 0; i < 50; i++)
            {
                _popQuestions.AddLast("Pop Question " + i);
                _scienceQuestions.AddLast(("Science Question " + i));
                _sportsQuestions.AddLast(("Sports Question " + i));
                _rockQuestions.AddLast(CreateRockQuestion(i));
            }
        }

        public string CreateRockQuestion(int index)
        {
            return "Rock Question " + index;
        }

        public bool Add(string playerName)
        {
            if (_players.Count >= MaxPlayersNumber)
            {
                throw new InvalidOperationException();
            }

            Player player = new Player(playerName,  0,  0, false);
            _players.Add(player);

            Console.WriteLine(playerName + " was added");
            Console.WriteLine("They are player number " + _players.Count);
            return true;
        }

        public int HowManyPlayers()
        {
            return _players.Count;
        }

        public void Roll(int roll)
        {
            Console.WriteLine(CurrentPlayer.Name + " is the current player");
            Console.WriteLine("They have rolled a " + roll);


            if (CurrentPlayer.IsInPenaltyBox)
            {
                if (roll % 2 == 0)
                {
                    Console.WriteLine(CurrentPlayer.Name + " is not getting out of the penalty box");
                }
                else
                {
                    //User is getting out of penalty box
                    CurrentPlayer.GetOutOfPenaltyBox();
                    //Write that user is getting out
                    Console.WriteLine(CurrentPlayer.Name + " is getting out of the penalty box");
                    MovePlayerAndAskQuestion(roll);
                }
            }
            else
            {
                MovePlayerAndAskQuestion(roll);
            }
        }

        

        private void MovePlayerAndAskQuestion(int roll)
        {
            MovePlayer(roll);

            Console.WriteLine(CurrentPlayer.Name
                              + "'s new location is "
                              + CurrentPlayer.Place);
            Console.WriteLine("The category is " + CurrentCategory());
            AskQuestion();
        }

        /// <summary>
        /// To call when the answer is right
        /// </summary>
        /// <returns></returns>
        public bool WasCorrectlyAnswered()
        {
            if (CurrentPlayer.IsInPenaltyBox)
            {
                NextPlayer();
                return true;
            }

            Console.WriteLine("Answer was correct!!!!");
            CurrentPlayer.AddGoldCoin();
            Console.WriteLine(CurrentPlayer.Name
                              + " now has "
                              + CurrentPlayer.Purse
                              + " Gold Coins.");

            NextPlayer();

            return IsAWinner();
        }

        public bool WrongAnswer()
        {
            Console.WriteLine("Question was incorrectly answered");
            Console.WriteLine(CurrentPlayer.Name + " was sent to the penalty box");
            CurrentPlayer.GoToPenaltyBox();

            NextPlayer();
            return false;
        }

        private bool IsAWinner()
        {
            return CurrentPlayer.Purse == ScoreToWin;
        }

        private void NextPlayer()
        {
            _currentPlayer++;
            if (_currentPlayer == _players.Count) _currentPlayer = 0;
        }

        private void AskQuestion()
        {
            if (CurrentCategory() == Category.Pop)
            {
                Console.WriteLine(_popQuestions.First());
                _popQuestions.RemoveFirst();
            }

            if (CurrentCategory() == Category.Science)
            {
                Console.WriteLine(_scienceQuestions.First());
                _scienceQuestions.RemoveFirst();
            }

            if (CurrentCategory() == Category.Sports)
            {
                Console.WriteLine(_sportsQuestions.First());
                _sportsQuestions.RemoveFirst();
            }

            if (CurrentCategory() == Category.Rock)
            {
                Console.WriteLine(_rockQuestions.First());
                _rockQuestions.RemoveFirst();
            }
        }

        private Category CurrentCategory()
        {
            switch (CurrentPlayer.Place)
            {
                case 0:
                case 4:
                case 8:
                    return Category.Pop;
                case 1:
                case 5:
                case 9:
                    return Category.Science;
                case 2:
                case 6:
                case 10:
                    return Category.Sports;
                default:
                    return Category.Rock;
            }
        }

        private void MovePlayer(int roll)
        {
            CurrentPlayer.Place = CurrentPlayer.Place + roll;
            if (CurrentPlayer.Place >= MaxPlacesNumber)
            {
                CurrentPlayer.Place = CurrentPlayer.Place - MaxPlacesNumber;
            }
        }
    }
}