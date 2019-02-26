package BackEnd

import scala.collection.mutable.ArrayBuffer

/** @author <Caroline Hart>
  * @group <Alyssa Shellman, Elijah Scuderi, Caroline Hart>
  * @version <2/18/2019>
  */

object Play {
  var myPlayers: ArrayBuffer[Player] = ArrayBuffer()
  def main(args: Array[String]): Unit = {

    val maze: Maze = new Maze(30,20)
    println(maze)
  }


  def newPlayer(name: String, position: Array[Int]): Unit = {
    /** //@param name, health,
      */
      val weapon =  new Weapon("", 0)
      val currentPlayer: Player = new Player(name, 100, weapon, position)
      this.myPlayers += currentPlayer
  }

  def findWinner(): Any = {
    /** @return <if one Player left, return Player, otherwise return false>
      */
      if (this.myPlayers.length == 1) {
        this.myPlayers(0)
      }
      else false
  }

  def eliminatePlayer(myPlayer: Player): Boolean = {
    /** //@param <Player to be eliminated>
      * @return <true if player was eliminated, false otherwise>
      */
      if (this.myPlayers.contains(myPlayer)) {
        this.myPlayers -= myPlayer
        true
      }
      else false
  }

}
