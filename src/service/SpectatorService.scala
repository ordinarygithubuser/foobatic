package service

import spectator.Spectator
import spectator.SpectatorRepository
import footballmatch.MatchRepository
import reservation.ReservationRepository
import shared.PriceCategory
import reservation.Reservation

object SpectatorService {

  /**
   * Creates a new Reservation for a Spectator
   */
  def reserveTicket (spectatorId: Int, matchId: Int, categoryName: String, amount: Int): Reservation = {
    val client = SpectatorRepository.get(spectatorId)
    val fooMatch = MatchRepository.get(matchId)
    val category = PriceCategory.create(categoryName)
    
    ReservationRepository.create(client, fooMatch, category, amount)
  }
  
  /**
   * Removes a reservation or reduces the amount of tickets if amount is smaller then the
   * Reservation's amount.
   */
  def cancelReservation (spectatorId: Int, matchId: Int, resId: Int, categoryName: String, amount: Int) {
    val res = ReservationRepository.get(resId)
    val client = SpectatorRepository.get(spectatorId)
    val fooMatch = MatchRepository.get(matchId)
    val category = PriceCategory.create(categoryName)
    val newAmount = res.amount - amount
    
    if (res.client.equals(client) && res.category.equals(category)) {
       ReservationRepository.remove(res)
       if (newAmount > 0) {
         ReservationRepository.create(client, fooMatch, category, newAmount)  
       }
    }
  }
  
  /**
   * Creates a new Spectator (registration)
   */
  def create (name: String, city: String, street: String, email: String, pCompany: String, pNumber: String): Spectator = {
    SpectatorRepository.create(name, city, street, email, pCompany, pNumber)
  }
  
  /**
   * Paying of a ticket
   */
  def payTicket (spectatorId: Int, matchId: Int, amount: Int): Int = {
      val spectator = SpectatorRepository.get(spectatorId)
      val fooMatch = MatchRepository.get(matchId)
      val res = ReservationRepository.get(fooMatch, spectator)
      val diff = res.calculatePrice() - amount
  
      if (diff <= 0) {
        res.setPaid
        diff    
      } else {
        throw new Exception("You provided not enough money. req/prov:" + res.calculatePrice() + "/" + amount)
      }
  }
}