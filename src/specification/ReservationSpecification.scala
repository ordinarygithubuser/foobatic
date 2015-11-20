package specification

import reservation.Reservation

trait ReservationSpecification {

  def isSatisfiedBy (reservation : Reservation);
  
}