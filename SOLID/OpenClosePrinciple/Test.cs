using Xunit;

namespace SOLID.OpenClosePrinciple
{

    public class ItinerarySearchTest
    {

        private readonly ItinerarySearchEngine search = new ItinerarySearchEngine();

        [Fact]
        public void should_find_shortest_itinerary()
        {
            var trip = Trip.from(City.Paris).to(City.Tokyo);

            var shortest = search.OptimalItinerary(trip, ItineraryPreference.Shortest);

            Assert.NotNull(shortest);
            Assert.Equal("Direct flight", shortest.Label);
        }

        [Fact]
        public void should_find_cheapest_itinerary()
        {
            var trip = Trip.from(City.Paris).to(City.Tokyo);

            var cheapest = search.OptimalItinerary(trip, ItineraryPreference.Cheapest);

            Assert.NotNull(cheapest);
            Assert.Equal("With Dubai stopover", cheapest.Label);
        }

    }

}
