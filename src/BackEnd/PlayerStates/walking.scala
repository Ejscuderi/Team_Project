package BackEnd.PlayerStates

import BackEnd.Player

class walking(player: Player) extends playerState(player) {


//  20 should be cell size

  override def aPress(): Unit = {
    player.position(0) = player.position(0) - 20
  }

  override def dPress(): Unit = {
    player.position(0) = player.position(0) + 20
  }

  override def wPress(): Unit = {
    player.position(1) = player.position(1) - 20
  }

  override def sPress(): Unit = {
    player.position(1) = player.position(1) + 20
  }
}
