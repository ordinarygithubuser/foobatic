package ticket

import model.Repository
import reservation.Reservation

// Act as a Database
object TicketRepository extends Repository[Ticket] {

  def create (reservation: Reservation, code: String): Ticket = {
    val ticket = TicketFactory.create(uid.next, reservation, code);
    save(ticket)
  }
  
}