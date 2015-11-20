package specification

import reservation.Reservation

class TicketCountSpecifiction (count: Int, limit: Int)  extends Exception (
  "You cannot buy more then " + limit + "tickets for a Match" + 
  "You tried to buy " + count + " tickets."
) {}

/**
 * Tests if the amount of Tickets of a given Reservation does not exceed a limit.
 */
object TicketCountSpecifiction extends ReservationSpecification {

  private val limit = 5;
  
  def isSatisfiedBy (res: Reservation) {
    if (res.amount > limit) throw new TicketCountSpecifiction(res.amount, limit)
  }
  
}