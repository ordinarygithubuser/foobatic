package reservation

import model.Repository
import spectator.Spectator
import shared.PriceCategory
import footballmatch.FootballMatch
import footballmatch.FootballMatch
import footballmatch.FootballMatch
import spectator.Spectator

object ReservationRepository extends Repository[Reservation] {

  /**
   * Creates a new Reservation.
   */
  def create (client: Spectator, fooMatch: FootballMatch, category: PriceCategory, amount: Int): Reservation = {
      save(ReservationFactory.create(uid.next, client, fooMatch, category, amount))
  }
  
  /**
   * Returns all Reservations of the FootballMatch fooMatch.
   */
  def getByMatch (fooMatch: FootballMatch): List[Reservation] = {
    items.filter { item => item.fooMatch.id.equals(fooMatch.id) }.toList  
  }
  
  def get (fooMatch: FootballMatch, client: Spectator): Reservation = {
    items.find { res => 
      res.fooMatch.id.equals(fooMatch.id) && res.client.equals(client) 
    }.getOrElse(throw new Exception("Invalid reservation with match/user:" + fooMatch.id + "/" + client.id))
  }
  
  /**
   * Removes all Reservations of the FootballMatch fooMatch, which are not
   * in the List winners.
   */
  def keep (fooMatch: FootballMatch, winners: List[Reservation]) {
    items.--=(getByMatch(fooMatch).filter { res => !winners.contains(res) })
  }
  
}