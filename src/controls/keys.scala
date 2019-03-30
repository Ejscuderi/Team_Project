package controls

import BackEnd.Player
import javafx.scene.input.KeyEvent
import javafx.event.EventHandler

//Alyssa
abstract class keys(player: Player) extends EventHandler[KeyEvent] {

  val left: String
  val right: String
  val up: String
  val down: String

  override def handle(event: KeyEvent): Unit = {
    val code = event.getCode
    event.getEventType.getName match {
      case "releaseKey" => code.getName match {
        case this.left => player.aReleased()
        case this.right => player.dReleased()
        case this.up => player.wReleased()
        case this.down => player.sReleased()
        case _ =>
      }
      case "pressKey" => code.getName match {
        case this.left => player.aPress()
        case this.right => player.dPress()
        case this.up => player.wPress()
        case this.down => player.sPress()
        case _ =>
      }
      case _ =>
    }
  }
}

class WASDInputs(player: Player) extends keys(player) {
  override val left: String = "A"
  override val right: String = "D"
  override val up: String = "W"
  override val down: String = "S"
}

//end Alyssa