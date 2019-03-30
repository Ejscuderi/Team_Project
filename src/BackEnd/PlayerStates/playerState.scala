package BackEnd.PlayerStates

import BackEnd.Player

abstract class playerState(player: Player) {


//  Alyssa
  def update(dt: Double): Unit = {

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
//end Alyssa