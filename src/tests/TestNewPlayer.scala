package tests

import BackEnd._
import org.scalatest.FunSuite
import scala.collection.mutable.ArrayBuffer

class TestNewPlayer extends FunSuite {
  test("Tests Backend.Play.newPlayer function") {
    val weapon = new Weapon("", 0)
    val player1 = new Player("Bob", 100, weapon, Array(0, 0))
    val player2 = new Player("Charles", 93, weapon, Array(1, 1))
    val player3 = new Player("Amy", 65, weapon, Array(12, 0))
    val player4 = new Player("Sophia", 12, weapon, Array(12, 5))
    val player5 = new Player("Cecelia", 100, weapon, Array(6, 12))
    val player6 = new Player("John", 100, weapon, Array(10,7))
    val player7 = new Player("Sarah", 100, weapon, Array(9,12))
    val player8 = new Player("Tom", 100, weapon, Array(5,15))

    BackEnd.Play.myPlayers = ArrayBuffer(player1, player2, player3, player4)
    BackEnd.Play.newPlayer("Cecelia", Array(6,12))
    assert(BackEnd.Play.myPlayers == ArrayBuffer(player1, player2, player3, player4, player5), 'test1)

    BackEnd.Play.newPlayer("John", Array(10,7))
    assert(BackEnd.Play.myPlayers == ArrayBuffer(player1, player2, player3, player4, player5, player6), 'test2)

    BackEnd.Play.newPlayer("Sarah", Array(9,12))
    assert(BackEnd.Play.myPlayers == ArrayBuffer(player1, player2, player3, player4, player5, player6, player7), 'test3)

    BackEnd.Play.newPlayer("Tom", Array(5,15))
    assert(BackEnd.Play.myPlayers == ArrayBuffer(player1, player2, player3, player4, player5, player6, player7, player8), 'test4)
  }
}
