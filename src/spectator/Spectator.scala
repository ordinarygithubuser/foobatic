package spectator

import model.Aggregate

/**
 * A Spectator owns a name, an Address and PaymentInformation.
 * A Spectator can reserve and cancel Tickets for a FootballMatch.
 */
class Spectator (
    val id: Int,
    val name: String, 
    val address: Address, 
    val payment: Payment
) extends Aggregate (id) {}