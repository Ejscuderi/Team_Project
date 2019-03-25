package BackEnd.PlayerStates

import BackEnd.Player

abstract class playerState(player: Player) {

  var timeInState: Double = 0.0

  def update(dt: Double): Unit = {
    timeInState += dt

    if(player.aPressed){
      this.aPress()
    }
    if(player.dPressed){
      this.dPress()
    }
    if(player.sPressed){
      this.sPress()
    }
    if(player.wPressed){
      this.wPress()
    }
  }


  def aPress(): Unit = {}

  def dPress(): Unit = {}

  def wPress(): Unit = {}

  def sPress(): Unit = {}

  def isAlive: Boolean = {
    true
  }
}
