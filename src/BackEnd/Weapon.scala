package BackEnd

import scala.util.Random

/**
  * @author <Caroline Hart>
  * @group <Alyssa Shellman, Elijah Scuderi, Caroline Hart>
  * @version <2/15/2019>
  * @todo <Some weapons need to be more rare than others>
  */


class Weapon(var name: String, var damage: Int) {
  /**
    * A weapon object can be obtained by players to use in the game
    * Players can use weapons to damage the health of their competitors
    */

  def findWeapon(): Weapon = {
    /**
      * @return <A new Weapon object>
      * @note <This method randomly assigns a Weapon object>
      */
    val randomNum: Int = Random.nextInt(4)
    if (randomNum == 0) {
      new Weapon("Sword", 20)
    }
    else if (randomNum == 1) {
      new Weapon("Gun", 40)
    }
    else if (randomNum == 2) {
      new Weapon("Axe", 25)
    }
    else {
      new Weapon("Baseball Bat", 10)
    }
  }
}
