package shared

import footballmatch.FootballMatch
import spectator.Spectator

class FooBaTicMailTemplate {
  
  val sendDeadline = (winner: Spectator, fooMatch: FootballMatch) => {
    val mail = new EMail(winner.address.email, "Payment deadline for: " + fooMatch.name)
    mail.send() 
  }
  
  val sendResult = (client: Spectator, fooMatch: FootballMatch, winners: List[Spectator]) => {
    var winStr = "*** "
    winners.map { winner => winStr += winner.name + " " }
    val mail = new EMail(client.address.email, "Results for Match " + fooMatch.name + ". The winners are: " + winStr + "***")
    mail.send()  
  }
  
  def sendReminder (client: Spectator, fooMatch: FootballMatch) {
    val mail = new EMail(client.address.email, "FooBaTic Reminder: You still need to pay the tickets for:" + fooMatch.name)
    mail.send()
  }
  
  def sendTicket (client: Spectator, fooMatch: FootballMatch, ticket: Ticket) {
    val mail = new EMail(client.address.email, "Congratulations: You won the tickets for: " + fooMatch.name + ". Your code is " + ticket.code)
    mail.send()
  }
  
}