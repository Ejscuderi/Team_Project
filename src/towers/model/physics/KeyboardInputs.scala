package towers.model.physics

import javafx.event.EventHandler
import javafx.scene.input.KeyEvent
import towers.model.game_objects.Player

abstract class KeyboardInputs(player: Player) extends EventHandler[KeyEvent] {

  val LEFT: String
  val RIGHT: String
  val UP: String
  val DOWN: String

  override def handle(event: KeyEvent): Unit = {
    val keyCode = event.getCode
    event.getEventType.getName match {
      case "KEY_PRESSED" => keyCode.getName match {
        case this.LEFT => player.move(new PhysicsVector(-1,0,0))
        case this.RIGHT => player.move(new PhysicsVector(1,0,0))
        case this.UP => player.move(new PhysicsVector(0,-1,0))
        case this.DOWN => player.move(new PhysicsVector(0,1,0))
        case _ =>
      }
      case _ =>
    }
  }
}

class WASDInputs(player: Player) extends KeyboardInputs(player) {
  override val LEFT: String = "A"
  override val RIGHT: String = "D"
  override val UP: String = "W"
  override val DOWN: String = "S"
}


class ArrowInputs(player: Player) extends KeyboardInputs(player) {
  override val LEFT: String = "Left"
  override val RIGHT: String = "Right"
  override val UP: String = "Up"
  override val DOWN: String = "Down"
}
