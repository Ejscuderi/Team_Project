package BackEnd

import BackEnd.PlayerStates.{playerState, standing, walking}

/** @author <Caroline Hart>
  * @group <Alyssa Shellman, Elijah Scuderi, Caroline Hart>
  * @version <2/15/2019>
  */

class Player(val name: String, var health: Int, var weapon: Weapon, var position: List[Int]) {
  /**
    * Each player has health and weapon
    */

//  Alyssa
  weapon = new Weapon("", 0)
  position = List(3, 3)

  var moveSpeed_x: Double = 10.0
  var moveSpeed_y: Double = 10.0

  var wPressed: Boolean = false
  var aPressed: Boolean = false
  var sPressed: Boolean = false
  var dPressed: Boolean = false

  var state: playerState = new standing(this)

  def aPress(): Unit = {
    state = new walking(this)
    this.aPressed = true
    this.state.aPress()
  }

  def dPress(): Unit = {
    state = new walking(this)
    this.dPressed = true
    this.state.aPress()
  }

  def wPress(): Unit = {
    state = new walking(this)
    this.wPressed = true
    this.state.wPress()
  }

  def sPress(): Unit = {
    state = new walking(this)
    this.sPressed = true
    this.state.sPress()
  }

  def aReleased(): Unit = {
    state = new standing(this)
    this.aPressed = false
  }

  def dReleased(): Unit = {
    state = new standing(this)
    this.dPressed = false
  }

  def wReleased(): Unit = {
    state = new standing(this)
    this.wPressed = false
  }

  def sReleased(): Unit = {
    state = new standing(this)
    this.sPressed = false
  }

//end Alyssa

//  Caroline
  def assignHitDamage(hitWeapon: Weapon): Unit = {
    /**
      * //@param: <Weapon Player was hit with>
      * @note <Sets Players health to health - Weapon.damage. If Players health is less than 0, set health to 0>
      */
    this.health -= hitWeapon.damage
    if (this.health < 0) {
      this.health = 0
    }
  }

  override def equals(that: Any): Boolean = {
    // Overridden equals method to aid TestNewPlayer in comparing Player objects
    that match {
      case that: Player => name == that.name && health == that.health && weapon.name == that.weapon.name && position(0) == that.position(0) && position(1) == that.position(1)
      case _ => false

    }
  }
}
//end Caroline