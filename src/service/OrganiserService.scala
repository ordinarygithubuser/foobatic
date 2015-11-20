package service

import scala.collection.mutable.ListBuffer

import footballmatch.MatchRepository
import reservation.ReservationRepository
import spectator.Spectator
import footballmatch.FootballMatch
import reservation.Reservation
import shared.NumberGenerator

object OrganiserService {

  /**
   * Draw the winners for a given match, cancel other reservations and inform
   * everyone with the results. Informs winners of the payments deadline.
   */
  def notifyClients (matchId: Int) {
    val fooMatch = MatchRepository.get(matchId)
    val candidates = ReservationRepository.getByMatch(fooMatch)
    val winners = drawWinners(candidates, getMaxCount(fooMatch, candidates))
    
    // TODO send result notification
    // TODO send payment deadline
    ReservationRepository.keep(fooMatch, winners);
  }
  
  private def drawWinners (candidates: List[Reservation], count: Int): List[Reservation] = {
    val winners = ListBuffer[Reservation]()
    
    for (i <- 0 until count) {
      val res = drawWinner(candidates, count - i)
      winners.+=(res)  
    }
    winners.toList
  }
  
  private def drawWinner (reservations: List[Reservation], count: Int): Reservation = {
    reservations((new NumberGenerator(count)).next)
  }
  
  private def getMaxCount (fooMatch: FootballMatch, candidates: List[Reservation]): Int = {
     if (fooMatch.ticketCount > candidates.size) candidates.size else fooMatch.ticketCount  
  }
  
  /**
   * Sends the tickets to every client that has paid. Otherwise a reminder
   * will be sent to inform the client that he still hasn't paid.
   */
  def sendTickets (matchName: String) {
    // TODO send ticket if paid, otherwise reminder message
  }
  
}