package shared

import scala.util.Random
import scala.collection.mutable.ListBuffer

class NumberGenerator (val max: Int) {

  val rand = new Random(System.currentTimeMillis())
  
  def next (): Int = {
    if (max == 0) 0 
    else rand.nextInt(max) 
  }
  
}