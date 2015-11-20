package spectator

object SpectatorFactory {
  
  /**
   * Returns a new instance of a Spectator.
   */
  def create (id: Int, name: String, city: String, street: String, email: String, pCompany: String, pNumber: String): Spectator = {
    new Spectator(id, name, new Address(city, street, email), new Payment(pCompany, pNumber));
  }
  
}