package footballmatch

import model.Repository

object MatchRepository extends Repository[FootballMatch] {

  /**
   * Creates a new instance of a FootballMatch.
   */
  def create (name: String, ticketCount: Int): FootballMatch = {
    save(MatchFactory.create(uid.next, name, ticketCount))
  }
  
}