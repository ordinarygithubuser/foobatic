package model

class UID {

  private var id = 0;
  
  def next: Int = {
    id = id + 1
    id
  }
  
}