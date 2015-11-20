package shared

object PriceCategory {
  
  def create (name: String): PriceCategory = {
    name match {
      case "A" => return new ACategory
      case "B" => return new BCategory
      case "C" => return new CCategory 
      case _   => throw new Exception("Invalid PriceCategory: " + name)
    }
  }
  
}

abstract class PriceCategory(val price: Int, val name: String) {
  
  override def equals (any: Any): Boolean = {
    any match {
      case category: PriceCategory => category.name.equals(name)
      case _ => false
    }
  }
  
}

case class ACategory() extends PriceCategory(200, "A")
case class BCategory() extends PriceCategory(150, "B")
case class CCategory() extends PriceCategory(100, "C")