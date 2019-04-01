package BackEnd

import scalafx.application.JFXApp

import scala.collection.mutable.ArrayBuffer

import scalaj.http.Http

/** @author <Caroline Hart>
  * @group <Alyssa Shellman, Elijah Scuderi, Caroline Hart>
  * @version <2/18/2019>
  */

object Play extends JFXApp{
  var myPlayers: ArrayBuffer[Player] = ArrayBuffer() // Stores all the players in the game

  def newPlayer(name: String, position: List[Int]): Unit = {
    /** //@param name, health
      * Adds a new player to the myPlayer ArrayBuffer
      */
      val weapon =  new Weapon("", 0) // Instantiate empty weapon
      val currentPlayer: Player = new Player(name, 100, weapon, position) // Create new Player with name, health = 100, empty weapon, position
      this.myPlayers += currentPlayer // Add new Player to the myPlayers ArrayBuffer
  }

  def findWinner(): Any = {
    /** @return <if one Player left, return Player, otherwise return false>
      * If one player is left, return that player
      * Else, return false
      */
      if (this.myPlayers.length == 1) { // If one Player in myPlayers array
        this.myPlayers(0) // return Player as winner
      }
      else false // No winner, return false
  }

  def eliminatePlayer(myPlayer: Player): Boolean = {
    /** //@param <Player to be eliminated>
      * @return <true if player was eliminated, false otherwise>
      * Takes player out of the myPlayers ArrayBuffer
      */
      if (this.myPlayers.contains(myPlayer)) { // if myPlayer in myPlayers ArrayBuffer
        this.myPlayers -= myPlayer // remove myPlayer from myPlayers ArrayBuffer
        true // myPlayer was removed from myPlayers ArrayBuffer
      }
      else false // myPlayer was not found in myPlayers ArrayBuffer
  }

  def createMaze(): Maze = {
    val maze : Maze = new Maze()
    maze
  }

}
