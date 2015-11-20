package model

import scala.collection.mutable.ListBuffer

trait Repository[T <: Aggregate] {
  
  protected final val uid = new UID()
  protected final var items = ListBuffer[T]()
  
  def get (id: Int): T = {
    if (exists(id)) items.find { _.id== id }.get
    else throw new Exception("")
  }
  
  def exists (id: Int): Boolean = {
    items.exists { _.id == id }
  }
  
  def save (t: T): T = {
    items.+=(t);
    t
  }
  
  def remove (t: T) {
    if (exists(t.id)) items.-=(t)  
  }
  
}