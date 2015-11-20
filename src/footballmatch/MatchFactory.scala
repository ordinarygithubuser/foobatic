package footballmatch

object MatchFactory {
  
  /**
   * Factory method to construct a new FootballMatch.
   */
  def create (id: Int, name: String, ticketCount: Int): FootballMatch = {
    new FootballMatch(id, name, ticketCount)
  }
  
}