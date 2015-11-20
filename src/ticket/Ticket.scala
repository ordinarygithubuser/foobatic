package ticket

import model.Aggregate
import reservation.Reservation

/**
 * A Ticket belongs to a reservation (and so to a FootballMatch) and
 * owns a unique code, which grants an owner access to a FootballMatch.
 */
class Ticket (
    val id: Int,
    val reservation: Reservation, 
    val code: String
) extends Aggregate(id) {}