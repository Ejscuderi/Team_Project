package tests

import BackEnd._
import org.scalatest.FunSuite
import scala.collection.mutable.ArrayBuffer

class TestEliminatePlayer extends FunSuite {
  test("Tests Backend.Play.eliminatePlayer function") {
    val weapon = new Weapon("", 0)
    val player1 = new Player("Bob", 100, weapon, Array(0, 0))
    val player2 = new Player("Charles", 93, weapon, Array(1, 1))
    val player3 = new Player("Amy", 65, weapon, Array(12, 0))
    val player4 = new Player("Sophia", 12, weapon, Array(12, 5))

    BackEnd.Play.myPlayers = ArrayBuffer(player1, player2, player3, player4)
    assert(BackEnd.Play.eliminatePlayer(player1), 'test1)

    BackEnd.Play.myPlayers = ArrayBuffer()
    assert(!BackEnd.Play.eliminatePlayer(player2), 'test2)

    BackEnd.Play.myPlayers = ArrayBuffer(player3)
    assert(!BackEnd.Play.eliminatePlayer(player4), 'test3)

    BackEnd.Play.myPlayers = ArrayBuffer(player1)
    assert(BackEnd.Play.eliminatePlayer(player1), 'test4)
  }
}
