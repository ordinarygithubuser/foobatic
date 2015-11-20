package reservation

import spectator.Spectator
import shared.PriceCategory
import footballmatch.FootballMatch
import specification.PriceLimitSpecifiction
import specification.TicketCountSpecifiction

object ReservationFactory {
  
  /**
   * Factory Method to construct new Reservations.
   */
  def create (id: Int, client: Spectator, fooMatch: FootballMatch, category: PriceCategory, amount: Int): Reservation = {
    val res = new Reservation(id, client, fooMatch, category, amount)
    PriceLimitSpecifiction.isSatisfiedBy(res)
    TicketCountSpecifiction.isSatisfiedBy(res)
    res
  }
  
}