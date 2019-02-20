package BackEnd

/**
  * @author <Caroline Hart>
  * @group <Alyssa Shellman, Elijah Scuderi, Caroline Hart>
  * @version <2/15/2019>
  */

class Player(var health: Int, var weapon: Weapon, var position: Array[Int]) {
  /**
    * Each player has health and weapon
    */

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
}
