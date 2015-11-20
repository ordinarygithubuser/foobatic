package ticket

import reservation.Reservation

object TicketFactory {
  
  def create (id: Int, reservation: Reservation, code: String): Ticket = {
    new Ticket(id, reservation, code)
  }
  
}