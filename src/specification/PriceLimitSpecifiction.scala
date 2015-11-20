package specification

import reservation.Reservation

class PriceLimitException (price: Int, limit: Int)  extends Exception (
  "You cannot buy tickets for a Match worth more then " + limit + "€.\n" + 
  "You tried to buy tickets for " + price + "€."
) {}

/**
 * Tests if the price of a given Reservation does not exceed a limit.
 */
object PriceLimitSpecifiction extends ReservationSpecification {

  private val limit = 2000;
  
  def isSatisfiedBy (res: Reservation) {
    val price = res.calculatePrice();
    if (price > limit) throw new PriceLimitException(price, limit)
  }
  
}