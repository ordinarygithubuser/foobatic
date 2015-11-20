package reservation

import spectator.Spectator
import shared.PriceCategory
import model.Aggregate
import footballmatch.FootballMatch

/**
 * A Reservation for a FootballMatch in a given PriceCategory and an amount of Tickets.
 * A Reservation is owned by one Spectator and is initially not paid. 
 */
class Reservation (
  val id: Int,
  val client: Spectator,
  val fooMatch: FootballMatch,
  val category: PriceCategory,
  val amount: Int
) extends Aggregate (id) {
  
  private var paid = false
  
  def calculatePrice (): Int = category.price * amount  
  
  def setPaid () = paid = true
  
  def isPaid (): Boolean = paid
  
}