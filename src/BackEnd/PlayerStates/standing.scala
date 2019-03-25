package BackEnd.PlayerStates
import BackEnd.Player

class standing(var player: Player) extends playerState(player) {

  override def wPress(): Unit = {}
  override def aPress(): Unit = {}
  override def sPress(): Unit = {}
  override def dPress(): Unit = {}
}
