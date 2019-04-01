package BackEnd.PlayerStates

import BackEnd.Player

class walking(player: Player) extends playerState(player) {


//  20 should be cell size

  override def aPress(): Unit = {
    //player.position.head -= 20
  }

  override def dPress(): Unit = {
    //player.position.head += 20
  }

  override def wPress(): Unit = {
    //player.position.apply(1) -= 20
  }

  override def sPress(): Unit = {
    //player.position.apply(1) += 20
  }
}
