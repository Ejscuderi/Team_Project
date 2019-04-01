package controller

import BackEnd.Player
import javafx.event.EventHandler
import scalafx.scene.input.KeyEvent



//Alyssa
abstract class keys(player: Player) extends EventHandler[KeyEvent] {

  val LEFT: String
  val RIGHT: String
  val UP: String
  val DOWN: String

  override def handle(event: KeyEvent): Unit = {
    val code = event.getCode
    event.getEventType.getName match {
      /**case "releaseKey" => code.getName match {
        case this.LEFT => player.aReleased()
        case this.RIGHT => player.dReleased()
        case this.UP => player.wReleased()
        case this.DOWN => player.sReleased()
        case _ =>
      }*/
      case "pressKey" => code.getName match {
        case this.LEFT => player.aPress()
        case this.RIGHT => player.dPress()
        case this.UP => player.wPress()
        case this.DOWN => player.sPress()
        case _ =>
      }
      case _ =>
    }
  }
}

class WASDInputs(player: Player) extends keys(player) {
  override val LEFT: String = "A"
  override val RIGHT: String = "D"
  override val UP: String = "W"
  override val DOWN: String = "S"
}

//end Alyssa