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
        private readonly List<string> _players = new List<string>();

        private readonly int[] _places = new int[MaxPlayersNumber];
        private readonly int[] _purses = new int[MaxPlayersNumber];

        private readonly bool[] _inPenaltyBox = new bool[MaxPlayersNumber];

        private readonly LinkedList<string> _popQuestions = new LinkedList<string>();
        private readonly LinkedList<string> _scienceQuestions = new LinkedList<string>();
        private readonly LinkedList<string> _sportsQuestions = new LinkedList<string>();
        private readonly LinkedList<string> _rockQuestions = new LinkedList<string>();

        private int _currentPlayer;
        private bool _isInPenaltyBox;

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
            _players.Add(playerName);
            _places[HowManyPlayers()] = 0;
            _purses[HowManyPlayers()] = 0;
            _inPenaltyBox[HowManyPlayers()] = false;

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
            Console.WriteLine(_players[_currentPlayer] + " is the current player");
            Console.WriteLine("They have rolled a " + roll);


            if (_inPenaltyBox[_currentPlayer])
            {
                if (roll % 2 == 0)
                {
                    Console.WriteLine(_players[_currentPlayer] + " is not getting out of the penalty box");
                    _inPenaltyBox[_currentPlayer] = true;
                }
                else
                {
                    //User is getting out of penalty box
                    _inPenaltyBox[_currentPlayer] = false;
                    //Write that user is getting out
                    Console.WriteLine(_players[_currentPlayer] + " is getting out of the penalty box");
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

            Console.WriteLine(_players[_currentPlayer]
                              + "'s new location is "
                              + _places[_currentPlayer]);
            Console.WriteLine("The category is " + CurrentCategory());
            AskQuestion();
        }

        /// <summary>
        /// To call when the answer is right
        /// </summary>
        /// <returns></returns>
        public bool WasCorrectlyAnswered()
        {
            if (_inPenaltyBox[_currentPlayer])
            {
                NextPlayer();
                return true;
            }

            Console.WriteLine("Answer was correct!!!!");
            _purses[_currentPlayer]++;
            Console.WriteLine(_players[_currentPlayer]
                              + " now has "
                              + _purses[_currentPlayer]
                              + " Gold Coins.");

            NextPlayer();

            return IsAWinner();
        }

        public bool WrongAnswer()
        {
            Console.WriteLine("Question was incorrectly answered");
            Console.WriteLine(_players[_currentPlayer] + " was sent to the penalty box");
            _inPenaltyBox[_currentPlayer] = true;

            NextPlayer();
            return false;
        }

        private bool IsAWinner()
        {
            return _purses[_currentPlayer] == ScoreToWin;
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
            switch (_places[_currentPlayer])
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
            _places[_currentPlayer] = _places[_currentPlayer] + roll;
            if (_places[_currentPlayer] >= MaxPlacesNumber)
            {
                _places[_currentPlayer] = _places[_currentPlayer] - MaxPlacesNumber;
            }
        }
    }

    internal enum Category
    {
        Pop,
        Science,
        Sports,
        Rock
    }
}