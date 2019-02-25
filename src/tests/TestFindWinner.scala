package tests

import BackEnd._
import org.scalatest._
import scala.collection.mutable.ArrayBuffer

class TestFindWinner extends FunSuite {
  test("Tests Backend.Play.findWinner function") {
    val weapon = new Weapon("", 0)
    val player1 = new Player("Bob", 100, weapon, Array(0, 0))
    val player2 = new Player("Charles", 93, weapon, Array(1, 1))
    val player3 = new Player("Amy", 65, weapon, Array(12, 0))
    val player4 = new Player("Sophia", 12, weapon, Array(12, 5))

    BackEnd.Play.myPlayers = ArrayBuffer(player1, player2, player3, player4)
    assert(BackEnd.Play.findWinner() == false, 'test1)

    BackEnd.Play.myPlayers = ArrayBuffer(player1, player2)
    assert(BackEnd.Play.findWinner() == false, 'test2)

    BackEnd.Play.myPlayers = ArrayBuffer(player3, player4)
    assert(BackEnd.Play.findWinner() == false, 'test3)

    BackEnd.Play.myPlayers = ArrayBuffer(player1)
    assert(BackEnd.Play.findWinner() == player1, 'test4)
  }
}
