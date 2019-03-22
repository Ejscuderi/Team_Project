package BackEnd

/** @author <Caroline Hart>
  * @group <Alyssa Shellman, Elijah Scuderi, Caroline Hart>
  * @version <2/15/2019>
  */

class Player(val name: String, var health: Int, var weapon: Weapon, var position: List[Int]) {
  /**
    * Each player has health and weapon
    */

//  Alyssa
  var moveSpeed: Double = 0.0
  var wPressed: Boolean = false
  var aPressed: Boolean = false
  var sPressed: Boolean = false
  var dPressed: Boolean = false
  var state: Player = new Player("Alyssa", 100, "gun", List(1, 2, 3))

  def aPress(): Unit = {
    this.aPressed = true
    this.state.aPress()
  }

  def dPress(): Unit = {
    this.dPressed = true
    this.state.aPress()
  }

  def wPress(): Unit = {
    this.wPressed = true
    this.state.wPress()
  }

  def sPress(): Unit = {
    this.sPressed = true
    this.state.sPress()
  }

  def aReleased(): Unit = {
    this.aPressed = false
    this.state.aReleased()
  }

  def dReleased(): Unit = {
    this.dPressed = false
    this.state.dReleased()
  }

  def wReleased(): Unit = {
    this.wPressed = false
    this.state.wReleased()
  }

  def sReleased(): Unit = {
    this.sPressed = false
    this.state.sReleased()
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

  def equals(that: Any): Boolean = {
    // Overridden equals method to aid TestNewPlayer in comparing Player objects
    that match {
      case that: Player => name == that.name && health == that.health && weapon.name == that.weapon.name && position(0) == that.position(0) && position(1) == that.position(1)
      case _ => false

    }
  }
}
//end Caroline