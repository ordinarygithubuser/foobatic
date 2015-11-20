package spectator

import model.Repository

object SpectatorRepository extends Repository[Spectator] {

  /**
   * Creates a new Spectator.
   */
  def create (name: String, city: String, street: String, email: String, pCompany: String, pNumber: String): Spectator = {
    save(SpectatorFactory.create(uid.next, name, city, street, email, pCompany, pNumber))
  }
  
}