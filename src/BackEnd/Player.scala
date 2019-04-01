package BackEnd


/** @author <Caroline Hart> // See comments
  * @group <Elijah Scuderi, Caroline Hart>
  * @version <2/15/2019>
  */

class Player(val name: String, var health: Int, var weapon: Weapon, var position: List[Int]) {
  /**
    * Each player has health and weapon
    */


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