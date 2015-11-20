package shared

class EMail (val mailAdress: String, val text: String) {

  def send () {
    println("Send email to winner " + mailAdress + ": " + text)
  }
  
}