// Version 1: 2/15/2019
// Author: Caroline Hart

import scala.util.Random

class Weapon(var name: String, var damage: Int) {
  /** A weapon object can be obtained by players to use in the game
    * Players can use weapons to damage the health of their competitors
    */
  def getWeapon(): Weapon = {
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
      new Weapon("Baseball Batt", 10)
    }
  }
}
